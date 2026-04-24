package com.example.recipe.menu.controller;

import com.example.recipe.menu.domain.Menu;
import com.example.recipe.menu.dto.DetailedMenuResponseDto;
import com.example.recipe.menu.dto.MenuCreateRequestDto;
import com.example.recipe.menu.dto.MenuResponseDto;
import com.example.recipe.menu.service.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class MenuController {
    MenuService menuService;

    MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    // 전체 메뉴 조회
    @GetMapping("/menus")
    ResponseEntity<List<MenuResponseDto>> getMenus(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuService.getMenus());
    }

    // 메뉴 생성
    @PostMapping("/menus")
    ResponseEntity<MenuResponseDto> createMenu(@RequestBody MenuCreateRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(menuService.createMenu(requestDto));
    }

    // 메뉴 상세 조회
    @GetMapping("/menus/{id}")
    ResponseEntity<DetailedMenuResponseDto> getDetailedMenu(@PathVariable Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(menuService.getDetailedMenu(id));
    }

    // 메뉴 삭제
    @DeleteMapping("/menus/{id}")
    ResponseEntity<Void> deleteMenu(@PathVariable Long id){
        menuService.deleteMenu(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}


