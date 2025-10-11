import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    private static final GerenciadorItens gerenciador = new GerenciadorItens();
    private static final Color COR_PRINCIPAL = new Color(150, 100, 118); // #966476

    private JFrame frame;
    private JTextField txtTitulo, txtDescricao, txtAutor, txtPaginas, txtDiretor, txtDuracao, txtFiltro;
    private JComboBox<String> cbTipo;
    private JTextArea txtResultados;
    private JProgressBar progressBar;
    private JLabel statusLabel;
    private JLabel imagemLabel;

    public static void main(String[] args) {
        carregarDadosIniciais();
        SwingUtilities.invokeLater(() -> new Main().criarEExibirGUI());
    }

    private void criarEExibirGUI() {
        frame = new JFrame("Cadastro de arquivos(filme e livro)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setSize(600, 500);

        frame.add(criarPainelEntrada(), BorderLayout.WEST);
        frame.add(criarPainelExibicao(), BorderLayout.CENTER);
        frame.add(criarPainelAcoes(), BorderLayout.SOUTH);
        frame.add(criarPainelStatus(), BorderLayout.NORTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        atualizarLista();
    }

    private JPanel criarPainelEntrada() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBackground(COR_PRINCIPAL);
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Título "Cadastrar Item" e imagem no topo (canto superior esquerdo)
        JPanel cabecalhoPanel = new JPanel(new BorderLayout(5, 5));
        cabecalhoPanel.setOpaque(false);
        JLabel tituloLabel = new JLabel("Cadastrar Item");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setForeground(Color.WHITE);
        cabecalhoPanel.add(tituloLabel, BorderLayout.WEST);

        // Painel de formulário abaixo do cabeçalho
        JPanel formularioPanel = new JPanel(new GridBagLayout());
        formularioPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        formularioPanel.add(new JLabel("Tipo:"), gbc);
        cbTipo = new JComboBox<>(new String[]{"Livro", "Filme"});
        cbTipo.addActionListener(e -> alternarCampos());
        gbc.gridx = 1;
        formularioPanel.add(cbTipo, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formularioPanel.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1;
        txtTitulo = new JTextField(15);
        formularioPanel.add(txtTitulo, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        formularioPanel.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1;
        txtDescricao = new JTextField(15);
        formularioPanel.add(txtDescricao, gbc);

        JPanel camposEspecificos = new JPanel(new GridLayout(0, 2, 5, 5));
        camposEspecificos.setOpaque(false);

        txtAutor = new JTextField(15);
        txtPaginas = new JTextField(15);
        txtDiretor = new JTextField(15);
        txtDuracao = new JTextField(15);

        camposEspecificos.add(new JLabel("Autor:"));
        camposEspecificos.add(txtAutor);
        camposEspecificos.add(new JLabel("Páginas:"));
        camposEspecificos.add(txtPaginas);
        camposEspecificos.add(new JLabel("Diretor:"));
        camposEspecificos.add(txtDiretor);
        camposEspecificos.add(new JLabel("Duração do filme:"));
        camposEspecificos.add(txtDuracao);

        txtDiretor.setVisible(false);
        txtDuracao.setVisible(false);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        formularioPanel.add(camposEspecificos, gbc);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBackground(COR_PRINCIPAL);
        btnAdicionar.setForeground(Color.WHITE);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        formularioPanel.add(btnAdicionar, gbc);

        btnAdicionar.addActionListener(e -> adicionarItem());

        painel.add(formularioPanel, BorderLayout.CENTER);

        return painel;
    }

    private void carregarImagem() {
        try {
            // Substitua "caminho/para/imagem.png" pelo caminho do seu arquivo PNG
            ImageIcon icone = new ImageIcon("livro.png"); // Exemplo, ajuste conforme necessário
            Image img = icone.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            imagemLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            System.err.println("Imagem não encontrada.\n Use um arquivo como 'livro.png' ou 'filme.png' no diretório.");
            imagemLabel.setText("Img");
            imagemLabel.setForeground(Color.WHITE);
        }
    }

    private JPanel criarPainelExibicao() {
        JPanel painel = new JPanel(new BorderLayout(5, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel filtroPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filtroPanel.add(new JLabel("Filtrar por Título:"));
        txtFiltro = new JTextField(20);
        JButton btnFiltrar = new JButton("Filtrar");
        btnFiltrar.setBackground(COR_PRINCIPAL);
        btnFiltrar.setForeground(Color.WHITE);
        btnFiltrar.addActionListener(e -> filtrarItens());
        filtroPanel.add(txtFiltro);
        filtroPanel.add(btnFiltrar);
        painel.add(filtroPanel, BorderLayout.NORTH);

        txtResultados = new JTextArea(15, 40);
        txtResultados.setEditable(false);
        txtResultados.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtResultados);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Resultados"));
        painel.add(scrollPane, BorderLayout.CENTER);

        return painel;
    }

    private JPanel criarPainelAcoes() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnListar = new JButton("Listar Todos");
        btnListar.setBackground(COR_PRINCIPAL);
        btnListar.setForeground(Color.WHITE);
        btnListar.addActionListener(e -> atualizarLista());

        JButton btnExportar = new JButton("Exportar Dados");
        btnExportar.setBackground(COR_PRINCIPAL);
        btnExportar.setForeground(Color.WHITE);
        btnExportar.addActionListener(e -> exportarDados());

        JButton btnImportar = new JButton("Importar Dados");
        btnImportar.setBackground(COR_PRINCIPAL);
        btnImportar.setForeground(Color.WHITE);
        btnImportar.addActionListener(e -> importarDados());

        painel.add(btnListar);
        painel.add(btnExportar);
        painel.add(btnImportar);

        return painel;
    }

    private JPanel criarPainelStatus() {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        statusLabel = new JLabel("Quantidade de itens disponivel: 0");
        statusLabel.setForeground(Color.WHITE);
        painel.setBackground(COR_PRINCIPAL);
        painel.add(statusLabel, BorderLayout.WEST);

        progressBar = new JProgressBar(0, 100);
        progressBar.setVisible(false);
        painel.add(progressBar, BorderLayout.EAST);

        return painel;
    }

    private void alternarCampos() {
        String tipo = (String) cbTipo.getSelectedItem();
        txtAutor.setVisible("Livro".equals(tipo));
        txtPaginas.setVisible("Livro".equals(tipo));
        txtDiretor.setVisible("Filme".equals(tipo));
        txtDuracao.setVisible("Filme".equals(tipo));
        frame.revalidate();
        frame.repaint();
    }

    private void adicionarItem() {
        try {
            String titulo = txtTitulo.getText().trim();
            String descricao = txtDescricao.getText().trim();
            String tipo = (String) cbTipo.getSelectedItem();

            if (titulo.isEmpty() || descricao.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Título e descrição são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Item item;
            if ("Livro".equals(tipo)) {
                String autor = txtAutor.getText().trim();
                int paginas = Integer.parseInt(txtPaginas.getText().trim());
                item = new livro(titulo, descricao, LocalDate.now(), autor, paginas);
            } else {
                String diretor = txtDiretor.getText().trim();
                int duracao = Integer.parseInt(txtDuracao.getText().trim());
                item = new filme(titulo, descricao, LocalDate.now(), diretor, duracao);
            }
            gerenciador.adicionarItem(item);
            JOptionPane.showMessageDialog(frame, "Item adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos();
            atualizarLista();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Páginas ou Duração devem ser números válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (CampoVazioException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void atualizarLista() {
        List<Item> itens = gerenciador.listarTodos();
        txtResultados.setText("");
        for (Item item : itens) {
            txtResultados.append(item.exibirDetalhes() + "\n-------------------------------------\n");
        }
        statusLabel.setText("Quantidade de itens disponivel: " + itens.size());
    }

    private void filtrarItens() {
        String filtro = txtFiltro.getText().trim();
        if (filtro.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Digite um nome para filtrar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        List<Item> itens = gerenciador.buscarPorTitulo(filtro);
        txtResultados.setText("");
        if (itens.isEmpty()) {
            txtResultados.setText("Nenhum item encontrado para '" + filtro + "'.");
        } else {
            for (Item item : itens) {
                txtResultados.append(item.exibirDetalhes() + "\n-------------------------------------\n");
            }
        }
    }

    private void exportarDados() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            progressBar.setVisible(true);
            progressBar.setValue(0);
            frame.repaint();
            gerenciador.exportarParaArquivo(fileChooser.getSelectedFile().getAbsolutePath());
            progressBar.setValue(100);
            JOptionPane.showMessageDialog(frame, "Exportação concluída!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            progressBar.setVisible(false);
        }
    }

    private void importarDados() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            progressBar.setVisible(true);
            progressBar.setValue(0);
            frame.repaint();
            gerenciador.importarDeArquivo(fileChooser.getSelectedFile().getAbsolutePath());
            progressBar.setValue(100);
            JOptionPane.showMessageDialog(frame, "Importação concluída!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            progressBar.setVisible(false);
            atualizarLista();
        }
    }

    private void limparCampos() {
        txtTitulo.setText("");
        txtDescricao.setText("");
        txtAutor.setText("");
        txtPaginas.setText("");
        txtDiretor.setText("");
        txtDuracao.setText("");
    }

    private static void carregarDadosIniciais() {
        try {
            gerenciador.adicionarItem(new livro("Trono de Vidro", "Fantasia", LocalDate.now(), "Sarah J. Maas", 500));
            gerenciador.adicionarItem(new filme("Oppenheimer", "Biografia científica", LocalDate.now(), "Christopher Nolan", 180));
        } catch (CampoVazioException e) {
            System.err.println("Erro ao carregar dados iniciais: " + e.getMessage());
        }
    }
}