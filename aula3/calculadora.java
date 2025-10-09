package aula3;

class calculadora {
    public int somar(int a, int b) {
        return a + b;
    }
    public double somar(double a, double b) {
        return a + b;
    }
    public int somar(int a, int b, int c) {
        return a + b + c;
    }
}

class Main {
    public static void main(String[] args) {
        calculadora calc = new calculadora();

        int result1 = calc.somar(5, 3);
        System.out.println("Soma de 5 e 3: " + result1);

        double result2 = calc.somar(3.5, 2.7);
        System.out.println("Soma de 3.5 e 2.7: " + result2);

        int result3 = calc.somar(1, 2, 3);
        System.out.println("Soma de 1, 2 e 3: " + result3);
    }
}