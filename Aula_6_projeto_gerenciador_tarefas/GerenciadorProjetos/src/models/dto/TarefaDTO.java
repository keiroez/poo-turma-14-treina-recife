package models.dto;

import models.Tarefa;

public record TarefaDTO(
    String titulo, String descricao
) {
    public TarefaDTO(Tarefa tarefa){
        this(tarefa.getTitulo(), tarefa.getDescricao());
    }

}
