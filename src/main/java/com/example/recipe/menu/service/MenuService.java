package com.example.recipe.menu.service;

import com.example.recipe.menu.domain.Menu;
import com.example.recipe.menu.dto.DetailedMenuResponseDto;
import com.example.recipe.menu.dto.MenuCreateRequestDto;
import com.example.recipe.menu.dto.MenuResponseDto;
import com.example.recipe.menu.repository.MenuRepository;
import com.example.recipe.step.repository.StepRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    MenuRepository menuRepository;
    StepRepository stepRepository;

    MenuService(MenuRepository menuRepository, StepRepository stepRepository){
        this.menuRepository = menuRepository;
        this.stepRepository = stepRepository;
    }

    public List<MenuResponseDto> getMenus() {
        List<Menu> menus = menuRepository.findAll();

        return menus.stream().map(menu ->
                new MenuResponseDto(menu.getId(), menu.getTitle(), menu.getDescription())
        ).toList();
    }

    public MenuResponseDto createMenu(MenuCreateRequestDto requestDto) {
        Menu requestMenu = new Menu(requestDto.getTitle(), requestDto.getDescription());

        Menu responseMenu = menuRepository.save(requestMenu);
        return new MenuResponseDto(responseMenu.getId(), responseMenu.getTitle(), responseMenu.getDescription());
    }

    public DetailedMenuResponseDto getDetailedMenu(Long menuId){
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));

        return new DetailedMenuResponseDto(menu.getId(), menu.getTitle(), menu.getDescription(), menu.getSteps());
    }
}
