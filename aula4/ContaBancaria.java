package aula4;

public abstract class ContaBancaria {
    protected double saldo;

    public ContaBancaria() {
        this.saldo = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract boolean sacar(double vl);
    public abstract void depositar(double vl);
}

class ContaCorrente extends ContaBancaria {
    private static final double taxa_saque = 1.00;

    public boolean sacar(double vl) {
        double valor_taxa = vl + taxa_saque;
        if (vl > 0 && saldo >= valor_taxa) {
            saldo -= valor_taxa;
            return true;
        }
        return false;
    }

    public void depositar(double vl) {
        if (vl > 0) {
            saldo += vl;
        }
    }
}

class ContaPoupanca extends ContaBancaria {
    public boolean sacar(double vl) {
        if (vl > 0 && saldo >= vl) {
            saldo -= vl;
            return true;
        }
        return false;
    }

    public void depositar(double vl) {
        if (vl > 0) {
            saldo += vl;
        }
    }
}

class Main {
    public static void main(String[] args) {

        ContaBancaria corrente = new ContaCorrente();
        ContaBancaria poupanca = new ContaPoupanca();

        System.out.println("Teste Conta Corrente");
        corrente.depositar(100.0);
        System.out.println("Saldo após depósito de R$100: R$" + corrente.getSaldo());
        boolean saque1 = corrente.sacar(50.0);
        System.out.println("Saque de R$50 (com taxa de R$1): " + (saque1 ? "Sucesso" : "Falha"));
        System.out.println("Saldo final: R$" + corrente.getSaldo());

        System.out.println("\nTeste Conta Poupança");
        poupanca.depositar(100.0);
        System.out.println("Saldo após depósito de R$100: R$" + poupanca.getSaldo());
        boolean saque2 = poupanca.sacar(50.0);
        System.out.println("Saque de R$50 (sem taxa): " + (saque2 ? "Sucesso" : "Falha"));
        System.out.println("Saldo final: R$" + poupanca.getSaldo());
    }
}