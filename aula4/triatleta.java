package aula4;

interface Corredor {
    void correr();
}

interface Nadador {
    void nadar();
}

interface Ciclista {
    void pedalar();
}

class triatleta implements Corredor, Nadador, Ciclista {
    private String nome;

    public triatleta(String nome) {
        this.nome = nome;
    }

    public void correr() {
        System.out.println(nome + " está correndo com energia.");
    }

    public void nadar() {
        System.out.println(nome + " está nadando com força.");
    }

    public void pedalar() {
        System.out.println(nome + " está pedalando com velocidade.");
    }
}

class Main {
    public static void main(String[] args) {
        triatleta triatleta = new triatleta("Edilayne");

        triatleta.correr();
        triatleta.nadar();
        triatleta.pedalar();
    }
}