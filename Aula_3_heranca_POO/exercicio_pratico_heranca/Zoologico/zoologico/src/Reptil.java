public class Reptil extends Animal {
    private boolean isAquatico;

    public Reptil(String nome, String sexo, int idade, boolean isAquatico) {
        super(nome, sexo, idade);
        this.isAquatico = isAquatico;
    }

    public boolean isAquatico() {
        return isAquatico;
    }

    public void setAquatico(boolean isAquatico) {
        this.isAquatico = isAquatico;
    }

}
