import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // POLIMORFIMO
        List<Pessoa> escola = new ArrayList<>();
        escola.add(new Aluno("Ana", 16, true));
        escola.add(new Professor("Carlos", 40, "Matemática"));
        for (Pessoa p : escola) {
            System.out.println(p.apresentar());
        }

        System.out.println("--------------------------------------------");

        var alunoInativo = new Aluno("Joao", 10, false);
        System.out.println(alunoInativo.apresentar());

        System.out.println("--------------------------------------------");

        Turma turma = new Turma();
        turma.getPessoas().add(new Aluno("Ana", 16, true));
        turma.getPessoas().add(new Aluno("Jose", 17, true));
        turma.getPessoas().add(new Aluno("Maria", 15, true));
        turma.getPessoas().add(new Professor("Carlos", 40, "Matemática"));

        System.out.println("Quantidade de alunos: " + turma.contarAlunos());
        turma.imprimirProfessores();

    }
}
