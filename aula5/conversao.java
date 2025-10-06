package aula5;

import java.util.Scanner;

class conversao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Digite um número inteiro: ");
            String entrada = scanner.nextLine();
            
            int num = Integer.parseInt(entrada);
            System.out.println("Número convertido com sucesso: " + num);
            
        } catch (NumberFormatException e) {
            System.out.println("Erro.");
        } finally {
            System.out.println("Encerrando programa...");
            scanner.close();
        }
    }
}