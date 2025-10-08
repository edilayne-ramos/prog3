<artifact artifact_id="etapa1-modelagem" artifact_version_id="v1" title="Etapa1_Modelagem.java" contentType="text/x-java">
import java.time.LocalDate;
// Classe abstrata Item
public abstract class Item {
protected String titulo;
protected String descricao;
protected LocalDate dataCadastro;
// Construtor
public Item(String titulo, String descricao) {
this.titulo = titulo;
this.descricao = descricao;
this.dataCadastro = LocalDate.now();
}
// Getters e Setters
public String getTitulo() {
return titulo;
}
public void setTitulo(String titulo) {
if (titulo != null && !titulo.trim().isEmpty()) {
this.titulo = titulo.trim();
} else {
throw new IllegalArgumentException("Título não pode ser nulo ou vazio.");
}
}
public String getDescricao() {
return descricao;
}
public void setDescricao(String descricao) {
if (descricao != null && !descricao.trim().isEmpty()) {
this.descricao = descricao.trim();
} else {
throw new IllegalArgumentException("Descrição não pode ser nula ou vazia.");
}
}
public LocalDate getDataCadastro() {
return dataCadastro;
}
// Método abstrato
public abstract String exibirDetalhes();
}
// Subclasse Livro
class Livro extends Item {
private String autor;
private int numeroPaginas;
public Livro(String titulo, String descricao, String autor, int numeroPaginas) {
super(titulo, descricao);
setAutor(autor);
setNumeroPaginas(numeroPaginas);
}
// Getters e Setters específicos
public String getAutor() {
return autor;
}
public void setAutor(String autor) {
if (autor != null && !autor.trim().isEmpty()) {
this.autor = autor.trim();
} else {
throw new IllegalArgumentException("Autor não pode ser nulo ou vazio.");
}
}
public int getNumeroPaginas() {
return numeroPaginas;
}
public void setNumeroPaginas(int numeroPaginas) {
if (numeroPaginas > 0) {
this.numeroPaginas = numeroPaginas;
} else {
throw new IllegalArgumentException("Número de páginas deve ser maior que zero.");
}
}
@Override
public String exibirDetalhes() {
return String.format(
"Livro: %s\n" +
"Descrição: %s\n" +
"Autor: %s\n" +
"Número de Páginas: %d\n" +
"Data de Cadastro: %s\n" +
"---------------------",
titulo, descricao, autor, numeroPaginas, dataCadastro
);
}
}
// Subclasse Filme
class Filme extends Item {
private String diretor;
private int duracaoMinutos;
public Filme(String titulo, String descricao, String diretor, int duracaoMinutos) {
super(titulo, descricao);
setDiretor(diretor);
setDuracaoMinutos(duracaoMinutos);
}
// Getters e Setters específicos
public String getDiretor() {
return diretor;
}
public void setDiretor(String diretor) {
if (diretor != null && !diretor.trim().isEmpty()) {
this.diretor = diretor.trim();
} else {
throw new IllegalArgumentException("Diretor não pode ser nulo ou vazio.");
}
}
public int getDuracaoMinutos() {
return duracaoMinutos;
}
public void setDuracaoMinutos(int duracaoMinutos) {
if (duracaoMinutos > 0) {
this.duracaoMinutos = duracaoMinutos;
} else {
throw new IllegalArgumentException("Duração deve ser maior que zero minutos.");
}
}
@Override
public String exibirDetalhes() {
return String.format(
"Filme: %s\n" +
"Descrição: %s\n" +
"Diretor: %s\n" +
"Duração: %d minutos\n" +
"Data de Cadastro: %s\n" +
"---------------------",
titulo, descricao, diretor, duracaoMinutos, dataCadastro
);
}
}
// Programa principal para testar as classes
class Main {
public static void main(String[] args) {
try {
// Criando um Livro
Livro livro = new Livro(
"O Pequeno Príncipe",
"Uma história sobre amizade e inocência",
"Antoine de Saint-Exupéry",
96
);
// Criando um Filme
Filme filme = new Filme(
"O Poderoso Chefão",
"Um épico sobre família e poder",
"Francis Ford Coppola",
175
);
// Exibindo detalhes
System.out.println("=== DETALHES DO LIVRO ===");
System.out.println(livro.exibirDetalhes());
System.out.println("\n=== DETALHES DO FILME ===");
System.out.println(filme.exibirDetalhes());
// Testando setters
System.out.println("\n=== TESTANDO ALTERAÇÕES ===");
livro.setDescricao("Nova descrição atualizada do livro.");
filme.setDuracaoMinutos(180);
System.out.println("\nLivro atualizado:");
System.out.println("Descrição: " + livro.getDescricao());
System.out.println("Páginas: " + livro.getNumeroPaginas());
System.out.println("\nFilme atualizado:");
System.out.println("Diretor: " + filme.getDiretor());
System.out.println("Duração: " + filme.getDuracaoMinutos() + " minutos");
} catch (IllegalArgumentException e) {
System.out.println("Erro de validação: " + e.getMessage());
}
}
}
</artifact>