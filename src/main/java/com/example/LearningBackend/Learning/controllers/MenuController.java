package com.example.LearningBackend.Learning.controllers;

import com.example.LearningBackend.Learning.model.DTO.MenuDTO;
import com.example.LearningBackend.Learning.services.MenuService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("Endpoint relacionado ao menu")
@RestController
@RequestMapping(value = "/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController {

    @Autowired
    private MenuService service;

    @GetMapping
    public ResponseEntity<List<MenuDTO>> buscarMenuOperador() {
        return ResponseEntity.ok().body(service.buscarMenu());
    }
}
