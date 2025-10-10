import java.util.*;

public class GerenciadorItens {
    private List<Item> itens;

    public GerenciadorItens() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) throws CampoVazioException {
        if (item == null) {
            throw new IllegalArgumentException("Item não pode ser nulo.");
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