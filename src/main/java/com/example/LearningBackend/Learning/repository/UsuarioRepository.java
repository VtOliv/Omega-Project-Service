package com.example.LearningBackend.Learning.repository;

import com.example.LearningBackend.Learning.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario , Long> {
    Usuario findByEmailAndSenha(String email, String senha);
    Usuario findByNomeUsuario(String nomeUsuario);
    Usuario findByEmail(String email);

}
