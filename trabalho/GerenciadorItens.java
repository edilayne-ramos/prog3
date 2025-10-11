import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class GerenciadorItens {
    private List<Item> itens;

    public GerenciadorItens() {
        this.itens = new ArrayList<>();
    }

    public void exportarParaArquivo(String caminho) {
        try (FileWriter fileWriter = new FileWriter(caminho);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Item item : itens) {
                bufferedWriter.write(item.exportar());
                bufferedWriter.newLine();
            }
            System.out.println("Exportação concluída com sucesso para: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao exportar para o arquivo: " + e.getMessage() + ". Tente novamente.");
        }
    }

    public void importarDeArquivo(String caminho) {
        try (FileReader fileReader = new FileReader(caminho);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length >= 6) { // Verifica se há dados suficientes
                    String tipo = partes[3];
                    Item item = null;
                    switch (tipo) {
                        case "Livro":
                            item = new livro(partes[0], partes[1], LocalDate.parse(partes[2]), partes[4], Integer.parseInt(partes[5]));
                            break;
                        case "Filme":
                            item = new filme(partes[0], partes[1], LocalDate.parse(partes[2]), partes[4], Integer.parseInt(partes[5]));
                            break;
                    }
                    if (item != null) {
                        itens.add(item);
                    }
                }
            }
            System.out.println("Importação concluída com sucesso de: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao importar do arquivo: " + e.getMessage() + ". Verifique o arquivo ou o caminho.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no formato dos dados no arquivo: " + e.getMessage() + ". Verifique o conteúdo.");
        }
    }

    public void adicionarItem(Item item) throws CampoVazioException {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser vazio.");
        }
        if (item.getTitulo() == null || item.getTitulo().isEmpty()) {
            throw new CampoVazioException("titulo");
        }
        if (item.getDescricao() == null || item.getDescricao().isEmpty()) {
            throw new CampoVazioException("descricao");
        }
        itens.add(item);
    }

    public List<Item> listarTodos() {
        return new ArrayList<>(itens);
    }

    public List<Item> buscarPorTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            return new ArrayList<>();
        }
        String lowerTitulo = titulo.toLowerCase();
        List<Item> resultado = new ArrayList<>();
        for (Item item : itens) {
            if (item.getTitulo().toLowerCase().contains(lowerTitulo)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public Map<String, Long> contarPorTipo() {
        Map<String, Long> contagem = new HashMap<>();
        for (Item item : itens) {
            String tipo = item.getClass().getSimpleName();
            contagem.put(tipo, contagem.getOrDefault(tipo, 0L) + 1);
        }
        return contagem;
    }

    public List<Item> listarTodosOrdenadosPorTitulo() {
        List<Item> ordenados = new ArrayList<>(itens);
        Collections.sort(ordenados, Comparator.comparing(Item::getTitulo));
        return ordenados;
    }
}