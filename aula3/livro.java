package aula3;

class livro {
    private String titulo;
    private String autor;

    // Construtor sem parâmetros com valores padrão
    public livro() {
        this.titulo = "Sem Título";
        this.autor = "Desconhecido";
    }

    // Construtor com parâmetros
    public livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Método para exibir os dados
    public void exibirDados() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println();
    }

    // Getters (opcional, para acesso aos atributos)
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}

class Main {
    public static void main(String[] args) {
        // Instanciando com construtor sem parâmetros
        livro livro1 = new livro();
        System.out.println("Dados do livro 1:");
        livro1.exibirDados();

        // Instanciando com construtor com parâmetros
        livro livro2 = new livro("Trono de Vidro", "Sarah J. Maas");
        System.out.println("Dados do livro 2:");
        livro2.exibirDados();
    }
}