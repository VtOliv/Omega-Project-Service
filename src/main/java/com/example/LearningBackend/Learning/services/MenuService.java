package com.example.LearningBackend.Learning.services;

import com.example.LearningBackend.Learning.helpers.MenuHelper;
import com.example.LearningBackend.Learning.model.DTO.MenuDTO;
import com.example.LearningBackend.Learning.model.entities.Menu;
import com.example.LearningBackend.Learning.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<MenuDTO> buscarMenu() {
            Set<Menu> menus = new HashSet<Menu>(menuRepository.findAll());

            List<MenuDTO> retorno = menus.stream().map(MenuHelper::toDTO).collect(Collectors.toList());

            retorno.sort((x, y) -> x.getCodigoMenu().compareTo(y.getCodigoMenu()));

            return retorno;


    }
}
