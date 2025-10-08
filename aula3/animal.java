package aula3;

class animal {
    public void emitirSom() {
        System.out.println("Som genérico de animal");
    }
}

class Cachorro extends animal {
    public void emitirSom() {
        System.out.println("Au Au!");
    }
}

class Gato extends animal {
    public void emitirSom() {
        System.out.println("Miau!");
    }
}

class Main {
    public static void main(String[] args) {
        animal[] animais = new animal[2];
        animais[0] = new Cachorro();
        animais[1] = new Gato();

        for (animal animal : animais) {
            animal.emitirSom();
        }
    }
}