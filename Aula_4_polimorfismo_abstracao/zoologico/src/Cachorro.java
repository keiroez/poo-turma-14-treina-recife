public class Cachorro extends Mamifero {

    private String raca;

    public Cachorro(String nome, String sexo, int idade, boolean isTerrestre) {
        super(nome, sexo, idade, isTerrestre);
    }

    @Override
    public void comer() {
        System.out.println("Comendo ração");
        
    }

    @Override
    public void emitirSom() {
        System.out.println("au au");
    }

 
    

}
