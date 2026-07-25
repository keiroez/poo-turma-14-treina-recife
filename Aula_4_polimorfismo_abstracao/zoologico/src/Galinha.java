public class Galinha extends Ave {

    public Galinha(String nome, String sexo, int idade, boolean isVoador) {
        super(nome, sexo, idade, isVoador);
    }

    @Override
    public void comer() {
        System.out.println("Comendo milho");
        
    }

    @Override
    public void emitirSom() {
        System.out.println("có có");
    }

}
