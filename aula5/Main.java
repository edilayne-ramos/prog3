package aula5;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Digite o primeiro número inteiro: ");
            int num1 = scanner.nextInt();
            System.out.print("Digite o segundo número inteiro: ");
            int num2 = scanner.nextInt();
            
            int result = num1 / num2;
            System.out.println("Resultado da divisão: " + result);
            
        } catch (ArithmeticException e) {
            System.out.println("Erro.");
        } catch (Exception e) {
            System.out.println("Erro.");
        } finally {
            scanner.close();
        }
    }
}