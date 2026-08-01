public abstract  class Pessoa {
    private String nome;
    private int idade;

    public abstract String apresentar();

    public Pessoa(String nome, int idade) {
        if(idade<0){
            throw new IllegalArgumentException("Idade não pode ser negativa");
        }
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
    
}
