import java.time.LocalDate;


public abstract class Item implements Exportavel{
    private String titulo;
    private String descricao;
    private LocalDate dataCadastro;

    public String exportar() {
        return String.format("%s|%s|%s", titulo, descricao, dataCadastro);
    }

    public abstract String exibirDetalhes();
    }
    
    public Item() {
        this.titulo = "";
        this.descricao = "";
        this.dataCadastro = LocalDate.now();
    }

    public Item(String titulo, String descricao, LocalDate dataCadastro) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
        }
        if (descricao == null) {
            throw new IllegalArgumentException("Descrição não pode ser nula.");
        }
        if (dataCadastro == null) {
            throw new IllegalArgumentException("Data de cadastro não pode ser nula.");
        }
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
        }
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null) {
            throw new IllegalArgumentException("Descrição não pode ser nula.");
        }
        this.descricao = descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        if (dataCadastro == null) {
            throw new IllegalArgumentException("Data de cadastro não pode ser nula.");
        }
        this.dataCadastro = dataCadastro;
    }

    public abstract String exibirDetalhes();
}