package aula6;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();

        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros.add(scanner.nextInt());
        }

        System.out.println("\nNúmeros inseridos: " + numeros);

        int soma = 0;
        for (int num : numeros) {
            soma += num;
        }
        double media = soma / (double) numeros.size();
        System.out.println("Soma total: " + soma);
        System.out.println("Média: " + media);

        // Removendo números pares
        numeros.removeIf(num -> num % 2 == 0);

        // Exibindo lista atualizada
        System.out.println("Lista após remover números pares: " + numeros);

        scanner.close();
    }
}