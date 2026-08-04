package models;

import enums.StatusProjeto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * ===================== CAMADA MODEL =====================
 *
 * Um Projeto AGRUPA várias tarefas e TEM UM usuário responsável.
 * Também é a mesma classe da Aula 6, com um construtor curto a mais.
 */
public class Projeto {

    private Long id;
    private String nome, descricao;
    private LocalDate dataInicio, dataConclusao;
    private StatusProjeto status;

    // RELACIONAMENTO: o projeto tem UM responsável (um objeto Usuario inteiro,
    // não só o nome dele!).
    private Usuario responsavel;

    // RELACIONAMENTO: o projeto tem VÁRIAS tarefas.
    private List<Tarefa> tarefas;

    /* CONSTRUTOR COMPLETO — o mesmo da Aula 6. */
    public Projeto(Long id, String nome, String descricao, LocalDate dataInicio, LocalDate dataConclusao,
            StatusProjeto status, Usuario responsavel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.status = status;
        this.responsavel = responsavel;
        this.tarefas = new ArrayList<>();
    }

    /*
     * CONSTRUTOR CURTO (sobrecarga): na tela de cadastro pedimos nome,
     * descrição, status e responsável. As datas preenchemos sozinhos:
     * - começa hoje (LocalDate.now())
     * - ainda não terminou (data de conclusão null)
     */
    public Projeto(Long id, String nome, String descricao, StatusProjeto status, Usuario responsavel) {
        this(id, nome, descricao, LocalDate.now(), null, status, responsavel);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public StatusProjeto getStatus() {
        return status;
    }

    public void setStatus(StatusProjeto status) {
        this.status = status;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public String toString() {
        return nome;
    }
}
