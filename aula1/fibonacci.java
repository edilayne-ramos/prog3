public class fibonacci {
    public static void main(String[] args) {

        int n_elementos = 30;
        int n1 = 1;
        int n2 = 1;
        int prox;

        System.out.println("Os " + n_elementos + " primeiros elementos da série de Fibonacci são:");

        System.out.print(n1 + ", " + n2);

        // Calcula e imprime os elementos
        for (int i = 3; i <= n_elementos; i++) {
            prox = n1 + n2;
            System.out.print(", " + prox);
            n1 = n2;
            n2 = prox;
        }
        System.out.println();
    }
}