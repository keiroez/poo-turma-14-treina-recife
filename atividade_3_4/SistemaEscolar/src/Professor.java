public class Professor extends Pessoa {
    private String disciplina;

    @Override
    public String apresentar() {
        /*
         * // "Ana, 16 anos, aluno(a) com matrícula ativa" ou "Carlos, 40 anos,
         * // professor de Matemática" .
         */

        return super.getNome() + ", " + super.getIdade() + " anos, professor de " + this.disciplina;
    }

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

}
