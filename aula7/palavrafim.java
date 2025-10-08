import java.io.PrintStream;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream writer = null;

        try {
            writer = new PrintStream("saida.txt");

            System.out.println("Digite 'FIM' para encerrar. \n Digite múltiplas linhas:");

            while (true) {
                String linha = scanner.nextLine();
                if (linha.equalsIgnoreCase("FIM")) {
                    break;
                }
                writer.println(linha);
            }

            System.out.println("Linhas gravadas com sucesso em saida.txt!");

        } catch (Exception e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
            scanner.close();
        }
    }
}