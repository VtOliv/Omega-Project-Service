package com.example.LearningBackend.Learning.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TB_MENU")
public class Menu {

    @Id
    @Column(name = "ID_MENU")
    private Long codigoMenu;

    @Column(name = "DS_MENU")
    private String descricao;

    @Column(name = "CD_CATEGORIA")
    private Long categoria;

    @Column(name = "DS_URL")
    private String url;
}