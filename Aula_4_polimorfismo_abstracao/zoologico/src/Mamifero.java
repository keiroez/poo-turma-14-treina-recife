public abstract  class Mamifero extends Animal {
    private boolean isTerrestre;

    public Mamifero(String nome, String sexo, int idade, boolean isTerrestre) {
        super(nome, sexo, idade);
        this.isTerrestre = isTerrestre;
    }

    public boolean isTerrestre() {
        return isTerrestre;
    }

    public void setTerrestre(boolean isTerrestre) {
        this.isTerrestre = isTerrestre;
    }

}
