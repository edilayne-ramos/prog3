import java.time.LocalDate;

public class filme extends Item {
    private String diretor;
    private int duracaoMinutos;

    public filme() {
        super();
        this.diretor = "";
        this.duracaoMinutos = 0;
    }

    public filme(String titulo, String descricao, LocalDate dataCadastro, String diretor, int duracaoMinutos) {
        super(titulo, descricao, dataCadastro);
        if (diretor == null || diretor.isEmpty()) {
            throw new IllegalArgumentException("Diretor não pode ser nulo ou vazio.");
        }
        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("Duração em minutos deve ser maior que zero.");
        }
        this.diretor = diretor;
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        if (diretor == null || diretor.isEmpty()) {
            throw new IllegalArgumentException("Diretor não pode ser nulo ou vazio.");
        }
        this.diretor = diretor;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("Duração em minutos deve ser maior que zero.");
        }
        this.duracaoMinutos = duracaoMinutos;
    }

   public String exportar() {
        return String.format("%s|%s|%s|Filme|%s|%d", getTitulo(), getDescricao(), getDataCadastro(), diretor, duracaoMinutos);
    }

    public String exibirDetalhes() {
        return "Filme: Título = " + getTitulo() + ", Descrição = " + getDescricao() + 
               ", Data de Cadastro = " + getDataCadastro() + ", Diretor = " + diretor + 
               ", Duração em Minutos = " + duracaoMinutos;
    }
}