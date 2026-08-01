package models;

import enums.Prioridade;
import enums.StatusTarefa;
import models.dto.TarefaDTO;
import models.dto.ToDTOInterface;

public class Tarefa implements ToDTOInterface<TarefaDTO> {
    private Long id;
    private String titulo, descricao;
    private Prioridade prioridade;
    private StatusTarefa status;

    private Usuario usuario;

    private Projeto projeto;

    @Override
    public TarefaDTO toDTO() {
        return new TarefaDTO(this);
    }

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

    

}
