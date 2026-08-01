package models.dto;

import enums.StatusProjeto;
import models.Projeto;

public record ProjetoDTO(
    String nome, String descricao, StatusProjeto status
) {
    public ProjetoDTO(Projeto projeto){
        this(projeto.getNome(), projeto.getDescricao(), projeto.getStatus());
    }
}
