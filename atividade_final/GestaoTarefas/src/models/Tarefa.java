package models;

import enums.Prioridade;
import enums.StatusTarefa;

/*
 * ===================== CAMADA MODEL =====================
 *
 * A Tarefa é o coração do sistema.
 * Ela SEMPRE pertence a um projeto e SEMPRE tem um responsável.
 */
public class Tarefa {

    private Long id;
    private String titulo, descricao;
    private Prioridade prioridade;
    private StatusTarefa status;

    // A tarefa guarda o OBJETO Usuario inteiro, não só o nome.
    // Assim, a partir da tarefa, conseguimos chegar em qualquer dado do responsável.
    private Usuario usuario;

    // Mesma ideia: guarda o OBJETO Projeto inteiro.
    private Projeto projeto;

    public Tarefa(Long id, String titulo, String descricao,
            Prioridade prioridade,
            StatusTarefa status,
            Usuario usuario,
            Projeto projeto) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.usuario = usuario;
        this.projeto = projeto;

        /*
         * RELACIONAMENTO NOS DOIS SENTIDOS (igual à Aula 6):
         *
         * A tarefa já sabe quem é o projeto e o usuário dela (linhas acima).
         * Aqui a tarefa faz o caminho de volta: se adiciona na lista dos dois.
         *
         * Resultado: depois disso, projeto.getTarefas() já mostra esta tarefa,
         * sem ninguém precisar lembrar de fazer isso na mão.
         *
         * O "this" aqui significa "esta tarefa que está sendo criada agora".
         */
        projeto.getTarefas().add(this);
        usuario.getTarefas().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
