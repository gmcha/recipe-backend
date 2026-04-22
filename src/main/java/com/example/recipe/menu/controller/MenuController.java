package com.example.recipe.menu.controller;

import com.example.recipe.menu.domain.Menu;
import com.example.recipe.menu.dto.DetailedMenuResponseDto;
import com.example.recipe.menu.dto.MenuCreateRequestDto;
import com.example.recipe.menu.dto.MenuResponseDto;
import com.example.recipe.menu.service.MenuService;
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
    List<MenuResponseDto> getMenus(){
        return menuService.getMenus();
    }

    // 메뉴 생성
    @PostMapping("/menus")
    MenuResponseDto createMenu(@RequestBody MenuCreateRequestDto requestDto) {
        return menuService.createMenu(requestDto);
    }

    // 메뉴 상세 조회
    @GetMapping("/menus/{id}")
    DetailedMenuResponseDto getDetailedMenu(@PathVariable Long id){
        return menuService.getDetailedMenu(id);
    }

    // 메뉴 삭제
    @DeleteMapping("/menus/{id}")
    void deleteMenu(@PathVariable Long id){
        menuService.deleteMenu(id);
    }
}


