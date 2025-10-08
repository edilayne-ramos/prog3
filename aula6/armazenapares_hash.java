package aula6;

import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> pessoas = new HashMap<>();

        System.out.println("Cadastre 5 pessoas:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Nome da pessoa " + (i + 1) + ": ");
            String nome = scanner.next();
            System.out.print("Idade: ");
            int idade = scanner.nextInt();
            pessoas.put(nome, idade);
        }

        System.out.println("\nPessoas cadastradas: " + pessoas);

        System.out.print("\nDigite um nome para consultar a idade: ");
        String nomeConsulta = scanner.next();
        if (pessoas.containsKey(nomeConsulta)) {
            System.out.println("Idade de " + nomeConsulta + ": " + pessoas.get(nomeConsulta) + " anos");
        } else {
            System.out.println("Nome não encontrado.");
        }

        System.out.print("Digite um nome para remover: ");
        String nomeRemover = scanner.next();
        if (pessoas.remove(nomeRemover) != null) {
            System.out.println("Pessoa " + nomeRemover + " removida com sucesso.");
        } else {
            System.out.println("Nome não encontrado para remoção.");
        }

        System.out.println("Pessoas após remoção: " + pessoas);

        scanner.close();
    }
}