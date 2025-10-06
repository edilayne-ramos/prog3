import java.util.ArrayList;
import java.util.Iterator;

public class armazena_alunos{

    public static void main(String[] args) {
        ArrayList<String> nome_aluno = new ArrayList<>();

        nome_aluno.add("Edilayne");
        nome_aluno.add("Fernanda");
        nome_aluno.add("Gabriel");
        nome_aluno.add("Tales");
        nome_aluno.add("Marina");
        nome_aluno.add("Gustavo");

        System.out.println("Lista inicial de alunos:");
        
        Iterator<String> iterator = nome_aluno.iterator();
        while (iterator.hasNext()) {
            String nome = iterator.next();
            System.out.println(nome);
        }

        nome_aluno.remove("Fernanda"); 
        
        // Exibe a lista atualizada
        System.out.println("\nLista de alunos após remover \"Carla\":");
        for (String nome : nome_aluno) {
            System.out.println(nome);
        }
    }
}