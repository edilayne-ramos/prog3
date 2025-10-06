package aula5;

import java.util.Scanner;

class calcularraiz {
    public static double calcularRaiz(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("ERRO");
        }
        return Math.sqrt(num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite um número inteiro: ");
            int num = scanner.nextInt();

            double result = calcularRaiz(num);
            System.out.printf("A raiz quadrada de %d é %.2f%n", num, result);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro.");
        } finally {
            scanner.close();
        }
    }
}