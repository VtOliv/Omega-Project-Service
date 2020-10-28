package com.example.LearningBackend.Learning.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long codigoUsuario;
    private String nomeUsuario;
    private String email;
    private String senha;
}
