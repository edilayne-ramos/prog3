import java.io.*;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = null;

        try {
            System.out.print("Digite o nome do arquivo de texto: ");
            String nomeArquivo = scanner.nextLine();

            FileInputStream fileInputStream = new FileInputStream(nomeArquivo);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            reader = new BufferedReader(inputStreamReader);

            String linha;
            System.out.println("\nConteúdo do arquivo:");
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                scanner.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar o stream.");
            }
        }
    }
}