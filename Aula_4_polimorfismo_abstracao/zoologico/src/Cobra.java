public class Cobra extends Reptil {

    public Cobra(String nome, String sexo, int idade, boolean isAquatico) {
        super(nome, sexo, idade, isAquatico);
    }

    @Override
    public void comer() {
        System.out.println("Comendo rato");
        
    }

    @Override
    public void emitirSom() {
        System.out.println("SSSiiiii");
    }

}
