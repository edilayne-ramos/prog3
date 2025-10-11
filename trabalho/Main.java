import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GerenciadorItens gerenciador = new GerenciadorItens();

        // Teste da Etapa 1 - Modelagem com Herança e Interfaces
        try {
            livro livro = new livro("Dom Casmurro", "Romance", LocalDate.now(), "Machado de Assis", 256);
            filme filme = new filme("Cidade de Deus", "Drama", LocalDate.now(), "Fernando Meirelles", 130);
            gerenciador.adicionarItem(livro);
            gerenciador.adicionarItem(filme);

            System.out.println("=== Teste Etapa 1 - Modelagem ===");
            System.out.println("Detalhes do Livro: " + livro.exibirDetalhes());
            System.out.println("Detalhes do Filme: " + filme.exibirDetalhes());
        } catch (CampoVazioException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste da Etapa 2 - Gerenciamento com Collections
        try {
            System.out.println("\n=== Teste Etapa 2 - Gerenciamento ===");
            System.out.println("Itens cadastrados:");
            for (Item item : gerenciador.listarTodos()) {
                System.out.println(item.exibirDetalhes());
            }

            System.out.println("\nItens por título (busca parcial 'Cidade'):");
            for (Item item : gerenciador.buscarPorTitulo("Cidade")) {
                System.out.println(item.exibirDetalhes());
            }

            System.out.println("\nContagem por tipo:");
            Map<String, Long> contagem = gerenciador.contarPorTipo();
            for (Map.Entry<String, Long> entry : contagem.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("\nItens ordenados por título:");
            for (Item item : gerenciador.listarTodosOrdenadosPorTitulo()) {
                System.out.println(item.exibirDetalhes());
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Teste da Etapa 3 - Java I/O
        try {
            System.out.println("\n=== Teste Etapa 3 - Java I/O ===");
            gerenciador.exportarParaArquivo("itens.txt");
            GerenciadorItens novoGerenciador = new GerenciadorItens(); // Novo gerenciador para importar
            novoGerenciador.importarDeArquivo("itens.txt");

            System.out.println("\nItens importados:");
            for (Item item : novoGerenciador.listarTodos()) {
                System.out.println(item.exibirDetalhes());
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}