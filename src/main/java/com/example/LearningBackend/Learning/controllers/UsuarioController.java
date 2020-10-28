package com.example.LearningBackend.Learning.controllers;


import com.example.LearningBackend.Learning.model.DTO.UsuarioDTO;
import com.example.LearningBackend.Learning.services.UsuarioService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("cadastrar")
    public ResponseEntity criarCliente(@RequestBody UsuarioDTO usuarioDTO){
        return service.criarUsuario(usuarioDTO);
    }
    @PostMapping("logar")
    public ResponseEntity realizarLogin(@RequestBody String[] dados){
        return service.fazerLogin(dados[0], dados[1]);
    }


}
