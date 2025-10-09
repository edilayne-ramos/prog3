package aula3;

class conta_bancaria {
    private int num;

    public conta_bancaria(int num) {
        this.num = num;
    }

    public String toString() {
        return "conta_bancaria[num=" + num + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        conta_bancaria outra = (conta_bancaria) obj;
        return num == outra.num;
    }

    public int getnum() {
        return num;
    }
}

class Main {
    public static void main(String[] args) {
        conta_bancaria conta1 = new conta_bancaria(12358);
        conta_bancaria conta2 = new conta_bancaria(54845);

        System.out.println("As contas são iguais? " + conta1.equals(conta2));
        System.out.println("Conta 1: " + conta1);
        System.out.println("Conta 2: " + conta2);
    }
}