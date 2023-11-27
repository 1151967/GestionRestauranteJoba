package com.restaurante.admin.service;

import com.restaurante.admin.dto.CategoriasDto;

import java.util.List;

public interface CategoriaService {

    List<CategoriasDto> obtenerCategoriasConPlatos();

    List<CategoriasDto> obtenerCategoriasConPlatosCompleto();

    List<CategoriasDto> obtenerCategorias();
}
