import java.time.LocalDate;

public class livro extends Item {
    private String autor;
    private int numeroPaginas;
    
    public livro() {
        super();
        this.autor = "";
        this.numeroPaginas = 0;
    }

    public livro(String titulo, String descricao, LocalDate dataCadastro, String autor, int numeroPaginas) {
        super(titulo, descricao, dataCadastro);
        if (autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser nulo ou vazio.");
        }
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("Número de páginas deve ser maior que zero.");
        }
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.isEmpty()) {
            throw new IllegalArgumentException("Autor não pode ser nulo ou vazio.");
        }
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        if (numeroPaginas <= 0) {
            throw new IllegalArgumentException("Número de páginas deve ser maior que zero.");
        }
        this.numeroPaginas = numeroPaginas;
    }

    public String exportar() {
        return String.format("%s|%s|%s|Livro|%s|%d", getTitulo(), getDescricao(), getDataCadastro(), autor, numeroPaginas);
    }

    public String exibirDetalhes() {
        return "----------------LIVRO----------------\nTítulo = " + getTitulo() + "\nDescrição = " + getDescricao() + 
               "\nData de Cadastro = " + getDataCadastro() + "\nAutor = " + autor + 
               "\nNúmero de Páginas = " + numeroPaginas;
    }
}