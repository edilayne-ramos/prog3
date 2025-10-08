import java.io.File;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo ou diretório: ");
        String caminho = scanner.nextLine();
        File arquivo = new File(caminho);

        if (arquivo.exists()) {
            if (arquivo.isFile()) {
                System.out.println("É um arquivo.");
            } else if (arquivo.isDirectory()) {
                System.out.println("É um diretório.");
            }

            System.out.println("Tamanho: " + arquivo.length() + " bytes");
            System.out.println("Caminho absoluto: " + arquivo.getAbsolutePath());

            if (arquivo.isDirectory()) {
                System.out.println("\nArquivos no diretório:");
                File[] arquivos = arquivo.listFiles();
                if (arquivos != null) {
                    for (File f : arquivos) {
                        System.out.println(f.getName());
                    }
                }
            }
        } else {
            System.out.println("O arquivo ou diretório não existe.");
        }

        scanner.close();
    }
}