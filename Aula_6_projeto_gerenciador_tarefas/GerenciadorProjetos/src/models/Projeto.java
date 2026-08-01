package models;

import enums.StatusProjeto;
import java.time.LocalDate;
import java.util.List;
import models.dto.ProjetoDTO;
import models.dto.ToDTOInterface;

public class Projeto implements ToDTOInterface<ProjetoDTO> {
    private Long id;
    private String nome, descricao;
    private LocalDate dataInicio, dataConclusao;
    private StatusProjeto status;
    private Usuario responsavel;

    private List<Tarefa> tarefas;

    @Override
    public ProjetoDTO toDTO() {
        return new ProjetoDTO(this);
    }

    public Projeto(Long id, String nome, String descricao, LocalDate dataInicio, LocalDate dataConclusao,
            StatusProjeto status, Usuario responsavel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.status = status;
        this.responsavel = responsavel;
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

}
