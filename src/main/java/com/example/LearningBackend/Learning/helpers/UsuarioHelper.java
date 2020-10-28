package com.example.LearningBackend.Learning.helpers;


import com.example.LearningBackend.Learning.model.DTO.UsuarioDTO;
import com.example.LearningBackend.Learning.model.entities.Usuario;

public class UsuarioHelper {

    public static UsuarioDTO toDTO(Usuario u) {
        return u != null ? UsuarioDTO.builder()
                .codigoUsuario(u.getCodigoUsuario())
                .nomeUsuario(u.getNomeUsuario())
                .email(u.getEmail())
                .senha(u.getSenha())
                .build() : null;
    }
}
