package com.example.LearningBackend.Learning.helpers;

import com.example.LearningBackend.Learning.model.DTO.MenuDTO;
import com.example.LearningBackend.Learning.model.entities.Menu;

import java.util.stream.Collectors;

public class MenuHelper {

    public static MenuDTO toDTO(Menu m) {
        return m != null ? MenuDTO.builder()
                .codigoMenu(m.getCodigoMenu())
                .descricao(m.getDescricao())
                .categoria(m.getCategoria())
                .url(m.getUrl())
                .build() : null;
    }
}
