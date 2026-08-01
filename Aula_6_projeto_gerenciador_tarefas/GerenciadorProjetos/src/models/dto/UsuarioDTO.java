package models.dto;

import models.Usuario;

public record UsuarioDTO(
                String nome, String email, String cpf) {
        public UsuarioDTO(Usuario usuario) {
                this(usuario.getNome(), usuario.getEmail(), usuario.getCpf());
        }
}
