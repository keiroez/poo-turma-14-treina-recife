public abstract  class Ave extends Animal {

    private boolean isVoador;

    public Ave(String nome, String sexo, int idade, boolean isVoador) {
        super(nome, sexo, idade);
        this.isVoador = isVoador;
    }

    public void voar(){
        if(isVoador){
            System.out.println(getNome()+" está voando.");
        }
    }

    public boolean isVoador() {
        return isVoador;
    }

    public void setVoador(boolean isVoador) {
        this.isVoador = isVoador;
    }

}
