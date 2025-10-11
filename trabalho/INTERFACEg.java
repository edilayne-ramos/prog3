import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.List;

public class INTERFACEg extends JFrame {
    private GerenciadorItens gerenciador;
    private JTextField txtTitulo, txtDescricao;
    private JComboBox<String> cbTipo;
    private JTextArea txtAreaResultados;
    private JButton btnAdicionar, btnListar, btnFiltrar, btnExportar, btnImportar;

    public INTERFACEg() {
        gerenciador = new GerenciadorItens();
        inicializarComponentes();
        configurarLayout();
        adicionarAcoes();
    }

    private void inicializarComponentes() {
        // Campos de texto
        txtTitulo = new JTextField(20);
        txtDescricao = new JTextField(20);

        // ComboBox para tipo
        cbTipo = new JComboBox<>(new String[]{"Livro", "Filme"});

        // Botões
        btnAdicionar = new JButton("Adicionar");
        btnListar = new JButton("Listar");
        btnFiltrar = new JButton("Filtrar");
        btnExportar = new JButton("Exportar Dados");
        btnImportar = new JButton("Importar Dados");

        // Área de texto para resultados
        txtAreaResultados = new JTextArea(10, 30);
        txtAreaResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtAreaResultados);

        // Configuração da janela
        setTitle("Gerenciador de Itens");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
    }

    private void configurarLayout() {
        // Painel principal com BorderLayout
        setLayout(new BorderLayout());

        // Painel lateral (esquerdo) para campos e botões
        JPanel painelLateral = new JPanel(new GridLayout(6, 2, 5, 5));
        painelLateral.add(new JLabel("Título:"));
        painelLateral.add(txtTitulo);
        painelLateral.add(new JLabel("Descrição:"));
        painelLateral.add(txtDescricao);
        painelLateral.add(new JLabel("Tipo:"));
        painelLateral.add(cbTipo);
        painelLateral.add(btnAdicionar);
        painelLateral.add(btnListar);
        painelLateral.add(btnFiltrar);
        painelLateral.add(btnExportar);
        painelLateral.add(btnImportar);

        // Personalização do painel lateral com a nova cor (#966476)
        painelLateral.setBackground(new Color(150, 100, 118)); // Conversão de #966476 para RGB

        // Painel central para resultados
        JPanel painelCentral = new JPanel(new BorderLayout());
        painelCentral.add(new JLabel("Resultados:"), BorderLayout.NORTH);
        painelCentral.add(new JScrollPane(txtAreaResultados), BorderLayout.CENTER);

        // Adicionando painéis à janela
        add(painelLateral, BorderLayout.WEST);
        add(painelCentral, BorderLayout.CENTER);

        // Personalização dos botões com a nova cor
        Color corPersonalizada = new Color(150, 100, 118);
        btnAdicionar.setBackground(corPersonalizada);
        btnListar.setBackground(corPersonalizada);
        btnFiltrar.setBackground(corPersonalizada);
        btnExportar.setBackground(corPersonalizada);
        btnImportar.setBackground(corPersonalizada);
        btnAdicionar.setForeground(Color.WHITE);
        btnListar.setForeground(Color.WHITE);
        btnFiltrar.setForeground(Color.WHITE);
        btnExportar.setForeground(Color.WHITE);
        btnImportar.setForeground(Color.WHITE);
    }

    private void adicionarAcoes() {
        btnAdicionar.addActionListener(e -> {
            try {
                String titulo = txtTitulo.getText().trim();
                String descricao = txtDescricao.getText().trim();
                String tipo = (String) cbTipo.getSelectedItem();

                if (titulo.isEmpty() || descricao.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Título e descrição não podem estar vazios.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Item item;
                if (tipo.equals("Livro")) {
                    item = new livro(titulo, descricao, LocalDate.now(), "Autor Exemplo", 100);
                } else {
                    item = new filme(titulo, descricao, LocalDate.now(), "Diretor Exemplo", 120);
                }
                gerenciador.adicionarItem(item);
                JOptionPane.showMessageDialog(this, "Item adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            } catch (CampoVazioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnListar.addActionListener(e -> {
            List<Item> itens = gerenciador.listarTodos();
            txtAreaResultados.setText("");
            for (Item item : itens) {
                txtAreaResultados.append(item.exibirDetalhes() + "\n");
            }
        });

        btnFiltrar.addActionListener(e -> {
            String filtro = JOptionPane.showInputDialog(this, "Digite o título para filtrar:", "Filtrar", JOptionPane.QUESTION_MESSAGE);
            if (filtro != null && !filtro.trim().isEmpty()) {
                List<Item> itens = gerenciador.buscarPorTitulo(filtro.trim());
                txtAreaResultados.setText("");
                for (Item item : itens) {
                    txtAreaResultados.append(item.exibirDetalhes() + "\n");
                }
            } else if (filtro != null) {
                JOptionPane.showMessageDialog(this, "Digite um título válido para filtrar.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnExportar.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                gerenciador.exportarParaArquivo(fileChooser.getSelectedFile().getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Dados exportados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnImportar.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                gerenciador.importarDeArquivo(fileChooser.getSelectedFile().getAbsolutePath());
                txtAreaResultados.setText("");
                for (Item item : gerenciador.listarTodos()) {
                    txtAreaResultados.append(item.exibirDetalhes() + "\n");
                }
                JOptionPane.showMessageDialog(this, "Dados importados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private void limparCampos() {
        txtTitulo.setText("");
        txtDescricao.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            INTERFACEg frame = new INTERFACEg();
            frame.setVisible(true);
        });
    }
}