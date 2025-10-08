package aula6;

import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> palavras = new HashSet<>();

        System.out.println("Digitar 'fim' será para encerrar.\n Digite palavras:");

        while (true) {
            String palavra = scanner.next();
            if (palavra.equals("fim")) {
                break;
            }
            palavras.add(palavra);
        }

        // Exibindo todas as palavras únicas
        System.out.println("\nPalavras únicas digitadas:");
        for (String p : palavras) {
            System.out.println(p);
        }

        // Verificando se "Java" foi digitada
        if (palavras.contains("Java")) {
            System.out.println("\nA palavra 'Java' foi digitada.");
        } else {
            System.out.println("\nA palavra 'Java' não foi digitada.");
        }

        scanner.close();
    }
}