package com.restaurante.admin.controller;

import com.restaurante.admin.dto.CategoriasDto;
import com.restaurante.admin.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriasController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/disponible")
    public ResponseEntity<List<CategoriasDto>> getCategoriasDisponibles() {
        return ResponseEntity.ok(categoriaService.obtenerCategorias());
    }
}
