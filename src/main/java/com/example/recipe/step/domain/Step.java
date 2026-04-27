package com.example.recipe.step.domain;

import com.example.recipe.menu.domain.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Step {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer stepNumber;

    private String content;

//    private Long menuId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "menu_id", nullable = false) // FK not null으로 지정
    Menu menu;

    public Step(Integer stepNumber, String content, Menu menu) {
        this.stepNumber = stepNumber;
        this.content = content;
        this.menu = menu;
    }
}
