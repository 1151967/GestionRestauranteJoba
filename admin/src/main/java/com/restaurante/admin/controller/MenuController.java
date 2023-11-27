package com.restaurante.admin.controller;

import com.restaurante.admin.dto.Menu;
import com.restaurante.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping
    public ResponseEntity<Menu> getCategoriasConPlatos() {
        return ResponseEntity.ok(menuService.obtenerMenu());
    }

    @GetMapping("/disponible")
    public ResponseEntity<Menu> getCategoriasConPlatosDisponibles() {
        return ResponseEntity.ok(menuService.obtenerMenuDisponible());
    }

}
