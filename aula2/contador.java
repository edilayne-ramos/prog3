public class contador {
    private static int t_objetos = 0;

    public contador() {
        t_objetos++;
        System.out.println("Contador criado. Total de objetos: " + t_objetos);
    }

    public static void mostra_total() {
        System.out.println("Total de objetos criados: " + t_objetos);
    }
    public static void main(String[] args) {
        contador c1 = new contador();
        contador c2 = new contador();
        contador c3 = new contador();

        contador.mostra_total();
    }
}