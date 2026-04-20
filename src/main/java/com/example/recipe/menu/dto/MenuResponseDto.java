package com.example.recipe.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MenuResponseDto {
    private Long id;
    private String title;
    private String description;
}
