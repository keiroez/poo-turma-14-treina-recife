import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Pessoa> pessoas;

    public Turma() {
        this.pessoas = new ArrayList<>();
    }

    public void imprimirProfessores() {
        for (Pessoa p : pessoas) {
            if (p instanceof Professor) {
                System.out.println(p.apresentar());
            }
        }
    }

    public int contarAlunos() {
        int contador = 0;

        for (Pessoa p : pessoas) {
            if (p instanceof Aluno) {
                contador++;
            }
        }

        return contador;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

}
