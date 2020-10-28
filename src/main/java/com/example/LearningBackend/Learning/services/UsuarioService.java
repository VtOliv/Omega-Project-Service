package com.example.LearningBackend.Learning.services;

import com.example.LearningBackend.Learning.model.DTO.UsuarioDTO;
import com.example.LearningBackend.Learning.model.entities.Usuario;
import com.example.LearningBackend.Learning.repository.UsuarioRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public ResponseEntity criarUsuario(UsuarioDTO usuarioDTO) {
        try {
            if (repository.findByEmail(usuarioDTO.getEmail()) != null) {
                return ResponseEntity.ok().body(1);
            }
            if (repository.findByNomeUsuario(usuarioDTO.getNomeUsuario()) != null) {
                return ResponseEntity.ok().body(2);
            }

            String senha = BCrypt.hashpw(usuarioDTO.getSenha(), BCrypt.gensalt());

            Usuario user = new Usuario();
            user.setNomeUsuario(usuarioDTO.getNomeUsuario());
            user.setEmail(usuarioDTO.getEmail());
            user.setSenha(senha);
            user = repository.save(user);

            UsuarioDTO usuarioDTOcriado = new UsuarioDTO(user.getCodigoUsuario(), user.getNomeUsuario(), user.getEmail(),
                    null);
            return ResponseEntity.ok().body(usuarioDTOcriado);
        }catch (Exception e){
            String erro = "Não foi possivel cadastrar o usuario!";
            return ResponseEntity.badRequest().body(erro);
        }
    }

    public ResponseEntity fazerLogin(String email, String senha) {
        try {
            Usuario usuario = repository.findByEmail(email);
            if (usuario != null && BCrypt.checkpw(senha, usuario.getSenha())){
                UsuarioDTO clienteDTO = new UsuarioDTO(usuario.getCodigoUsuario(), usuario.getNomeUsuario(),
                        usuario.getEmail(), null);
                return ResponseEntity.ok().body(clienteDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e){
            String erro = "Não foi possivel autenticar tente novamente";
            return ResponseEntity.badRequest().body(erro);
        }
    }

}
