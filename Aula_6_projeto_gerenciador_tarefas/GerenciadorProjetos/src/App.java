
import enums.Prioridade;
import enums.StatusProjeto;
import enums.StatusTarefa;
import enums.StatusUsuario;
import java.time.LocalDate;
import models.Projeto;
import models.Tarefa;
import models.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        Usuario usuario = new Usuario(
                1L,
                "Pedro",
                "12345678901",
                "pedro@pedro.com",
                "12345",
                LocalDate.now(),
                StatusUsuario.ATIVO);

        Projeto projeto = new Projeto(
                1L,
                "Do zero ao fullstack",
                "null",
                LocalDate.now(),
                LocalDate.now(),
                StatusProjeto.ATIVO,
                usuario);

        Usuario usuarioMaria = new Usuario(
                2L,
                "Maria",
                "12345678901",
                "maria@maria.com",
                "12345",
                LocalDate.now(),
                StatusUsuario.ATIVO);

        Tarefa tarefa = new Tarefa(
            1L, 
            "POO - Projeto",
            "Fazer gerenciador de tarefas", 
            Prioridade.MEDIA, 
            StatusTarefa.PENDENTE, 
            usuarioMaria, 
            projeto
        );

        System.out.println(projeto.getTarefas().size());
    }
}
