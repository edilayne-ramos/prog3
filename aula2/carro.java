public class carro {
    private String marca;
    private String modelo;
    private int ano;

    public carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public void exibirInfo() {
        System.out.println(".....Informações do carro.....");
        System.out.println("Marca: " + this.marca + "Modelo: " + this.modelo + "Ano: " + this.ano);
        System.out.println();
    }
    public static void main(String[] args) {
        carro carro1 = new carro("Volkswagen", "Fusca", 1997);
        carro1.exibirInfo();

        carro carro2 = new carro("Honda", "Civic", 2017);
        carro2.exibirInfo();
    }
}