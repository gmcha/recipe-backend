package com.example.recipe.step.controller;

import com.example.recipe.menu.dto.MenuResponseDto;
import com.example.recipe.step.domain.Step;
import com.example.recipe.step.dto.StepRequestDto;
import com.example.recipe.step.dto.StepResponseDto;
import com.example.recipe.step.service.StepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class StepController {
    StepService stepService;

    StepController(StepService stepService){
        this.stepService = stepService;
    }

    // 전체 Steps 수정 (생성, 순서 이동, 수정, 삭제)
    @PutMapping("/steps/menu/{menuId}")
    ResponseEntity<List<StepResponseDto>> updateSteps(@PathVariable Long menuId, @RequestBody List<StepRequestDto> requestDtos){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(stepService.updateSteps(menuId, requestDtos));
    }
}
