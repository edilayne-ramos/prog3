import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        GerenciadorItens gerenciador = new GerenciadorItens();
        try {
            livro livro = new livro("Dom Casmurro", "Romance", LocalDate.now(), "Machado de Assis", 256);
            filme filme = new filme("Cidade de Deus", "Drama", LocalDate.now(), "Fernando Meirelles", 130);
            gerenciador.adicionarItem(livro);
            gerenciador.adicionarItem(filme);

            System.out.println("Itens cadastrados:");
            for (Item item : gerenciador.listarTodos()) {
                System.out.println(item.exibirDetalhes());
            }

            System.out.println("\nItens por título (busca parcial 'Cidade'):");
            for (Item item : gerenciador.buscarPorTitulo("Cidade")) {
                System.out.println(item.exibirDetalhes());
            }

            System.out.println("\nContagem por tipo:");
            System.out.println(gerenciador.contarPorTipo());

            System.out.println("\nItens ordenados por título:");
            for (Item item : gerenciador.listarTodosOrdenadosPorTitulo()) {
                System.out.println(item.exibirDetalhes());
            }
        } catch (CampoVazioException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}