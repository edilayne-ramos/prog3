package aula4;

enum NivelAcesso {
    basico,
    intermediario,
    admin
}

class Usuario {
    private String nome;
    private NivelAcesso nivelAcesso;

    public Usuario(String nome, NivelAcesso nivelAcesso) {
        this.nome = nome;
        this.nivelAcesso = nivelAcesso;
    }

    public String getNome() {
        return nome;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public String getMensagemPersonalizada() {
        switch (nivelAcesso) {
            case basico:
                return "Bem-vindo, " + nome + "! Você tem acesso básico ao sistema.";
            case intermediario:
                return "Olá, " + nome + "! Você tem acesso intermediário ao sistema.";
            case admin:
                return "Saudações, " + nome + "! Você tem acesso administrativo completo.";
            default:
                return "Acesso inválido para " + nome + ".";
        }
    }
}

class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Edilayne", NivelAcesso.basico);
        Usuario usuario2 = new Usuario("Gabriel", NivelAcesso.intermediario);
        Usuario usuario3 = new Usuario("Tales", NivelAcesso.admin);

        System.out.println(usuario1.getMensagemPersonalizada());
        System.out.println(usuario2.getMensagemPersonalizada());
        System.out.println(usuario3.getMensagemPersonalizada());
    }
}