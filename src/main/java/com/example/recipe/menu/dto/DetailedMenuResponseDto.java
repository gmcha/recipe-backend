package com.example.recipe.menu.dto;

import com.example.recipe.step.domain.Step;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class DetailedMenuResponseDto {
    private Long id;
    private String title;
    private String description;
    private List<Step> steps;

}
