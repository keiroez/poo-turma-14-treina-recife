package controller;

import enums.Prioridade;
import enums.StatusProjeto;
import enums.StatusTarefa;
import enums.StatusUsuario;
import java.util.ArrayList;
import java.util.List;
import models.Projeto;
import models.Tarefa;
import models.Usuario;

/*
 * ===================== CAMADA CONTROLLER =====================
 *
 * O CONTROLLER é o "cérebro" que fica NO MEIO da tela e do model.
 *
 *      TELA (view)  ->  CONTROLLER  ->  OBJETOS (model)
 *      "o usuário       "isso é         Usuario, Projeto,
 *       clicou"          válido?"        Tarefa
 *
 * Ele tem três métodos, um para cada cadastro:
 *      cadastrarUsuario(...)
 *      cadastrarProjeto(...)
 *      cadastrarTarefa(...)
 *
 * Regra de ouro do MVC:
 *   - A TELA não cria objeto e não valida nada. Ela só mostra e pergunta.
 *   - O CONTROLLER não sabe o que é botão, campo de texto ou tabela.
 *     Repare que NÃO existe nenhum import de javax.swing aqui!
 */
public class SistemaController {

    // Estas listas são a "memória" do programa enquanto ele está aberto.
    // (Quando fechar, tudo se perde — banco de dados fica para os próximos módulos!)
    private List<Usuario> usuarios;
    private List<Projeto> projetos;
    private List<Tarefa> tarefas;

    /*
     * Contadores para gerar o id de cada objeto novo.
     * Começam em 1 e vão aumentando: 1, 2, 3...
     * É o nosso "auto incremento" na mão.
     */
    private long proximoIdUsuario = 1;
    private long proximoIdProjeto = 1;
    private long proximoIdTarefa = 1;

    public SistemaController() {
        this.usuarios = new ArrayList<>();
        this.projetos = new ArrayList<>();
        this.tarefas = new ArrayList<>();
    }

    /* ---------------- 1) CADASTRO DE USUÁRIO ---------------- */
    public Usuario cadastrarUsuario(String nome, String email, StatusUsuario status) {

        /*
         * VALIDAÇÃO: isBlank() é true quando o texto está vazio OU só tem espaços.
         * Quando algo está errado, LANÇAMOS uma exceção (igual à Aula 5).
         * Quem chamou (a tela) captura com try/catch e mostra a mensagem na telinha.
         */
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do usuário é obrigatório.");
        }

        // Não deixamos cadastrar dois usuários com o mesmo nome.
        for (Usuario usuario : usuarios) {
            // Para comparar textos use equals, NUNCA ==
            if (usuario.getNome().equalsIgnoreCase(nome.trim())) {
                throw new IllegalArgumentException("Já existe um usuário chamado " + nome.trim() + ".");
            }
        }

        // trim() tira os espaços sobrando do começo e do fim do texto.
        Usuario usuario = new Usuario(proximoIdUsuario, nome.trim(), email.trim(), status);
        proximoIdUsuario++;

        usuarios.add(usuario);
        return usuario;
    }

    /* ---------------- 2) CADASTRO DE PROJETO ---------------- */
    public Projeto cadastrarProjeto(String nome, String descricao, StatusProjeto status, Usuario responsavel) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do projeto é obrigatório.");
        }

        /*
         * O responsável vem de um JComboBox lá na tela.
         * Se nenhum usuário foi cadastrado ainda, o combo está vazio
         * e chega null aqui — por isso avisamos qual é a ordem certa.
         */
        if (responsavel == null) {
            throw new IllegalArgumentException("Cadastre um usuário primeiro para ser o responsável.");
        }

        for (Projeto projeto : projetos) {
            if (projeto.getNome().equalsIgnoreCase(nome.trim())) {
                throw new IllegalArgumentException("Já existe um projeto chamado " + nome.trim() + ".");
            }
        }

        Projeto projeto = new Projeto(proximoIdProjeto, nome.trim(), descricao.trim(), status, responsavel);
        proximoIdProjeto++;

        projetos.add(projeto);
        return projeto;
    }

    /* ---------------- 3) CADASTRO DE TAREFA ---------------- */
    public Tarefa cadastrarTarefa(String titulo, String descricao, Prioridade prioridade,
            StatusTarefa status, Projeto projeto, Usuario responsavel) {

        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da tarefa é obrigatório.");
        }

        if (projeto == null) {
            throw new IllegalArgumentException("Cadastre um projeto primeiro para vincular a tarefa.");
        }

        if (responsavel == null) {
            throw new IllegalArgumentException("Cadastre um usuário primeiro para ser o responsável.");
        }

        /*
         * Repare que projeto e responsável NÃO são texto: são os OBJETOS
         * que já estão nas listas. É isso que significa "vincular".
         *
         * O construtor da Tarefa já a coloca na lista do projeto e do
         * usuário automaticamente — veja o comentário em Tarefa.java.
         */
        Tarefa tarefa = new Tarefa(
                proximoIdTarefa,
                titulo.trim(),
                descricao.trim(),
                prioridade,
                status,
                responsavel,
                projeto);

        proximoIdTarefa++;

        tarefas.add(tarefa);
        return tarefa;
    }

    // Getters para a tela conseguir ler as listas, montar as tabelas e os combos.
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }
}
