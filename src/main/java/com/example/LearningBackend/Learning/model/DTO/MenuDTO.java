package com.example.LearningBackend.Learning.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDTO {
    private Long codigoMenu;
    private String descricao;
    private Long categoria;
    private String url;
}
