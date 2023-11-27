package com.restaurante.admin.service.serviceImpl;

import com.restaurante.admin.dto.Menu;
import com.restaurante.admin.service.CategoriaService;
import com.restaurante.admin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public Menu obtenerMenuDisponible() {
        Menu menu = new Menu();
        menu.setCategoriasDisponibles(categoriaService.obtenerCategoriasConPlatos());
        return menu;
    }

    @Override
    public Menu obtenerMenu() {
        Menu menu = new Menu();
        menu.setCategoriasDisponibles(categoriaService.obtenerCategoriasConPlatosCompleto());
        return menu;
    }

}
