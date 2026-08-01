public class Aluno extends Pessoa {
    private boolean matriculaAtiva;

    public Aluno(String nome, int idade, boolean matriculaAtiva) {
        super(nome, idade);
        this.matriculaAtiva = matriculaAtiva;
    }

    @Override
    public String apresentar() {
        String isAtiva;
        if (this.matriculaAtiva) {
            isAtiva = "ativa";
        } else {
            isAtiva = "inativa";
        }

        // SUBSTITUI O IF ACIMA SE QUISER
        // String ativa = this.matriculaAtiva ? "ativa": "inativa";

        return super.getNome() + ", " + super.getIdade() + " anos, aluno(a) com matricula " + isAtiva;
    }

    public boolean isMatriculaAtiva() {
        return matriculaAtiva;
    }

    public void setMatriculaAtiva(boolean matriculaAtiva) {
        this.matriculaAtiva = matriculaAtiva;
    }

}
