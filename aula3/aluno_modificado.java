package aula3;

class aluno_modificado {
    private String nome;
    private int idade;

    public aluno_modificado(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome.trim();
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        }
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}

class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, int idade, String matricula) {
        super(nome, idade);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula != null && !matricula.trim().isEmpty()) {
            this.matricula = matricula.trim();
        }
    }

    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Matrícula: " + matricula);
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Edilayne", 22, "202311722010");
        System.out.println("Informações iniciais do Aluno:");
        aluno.exibirInformacoes();

        System.out.println("Nome acessado: " + aluno.getNome());
        System.out.println("Idade acessada: " + aluno.getIdade());
        System.out.println("Matrícula acessada: " + aluno.getMatricula());

        aluno.setNome("Gabriel Marchesan");
        aluno.setIdade(23);
        aluno.setMatricula("202111722017");
        System.out.println("\nInformações após modificação:");
        aluno.exibirInformacoes();
    }
}