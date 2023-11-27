package com.restaurante.admin.service.serviceImpl;

import com.restaurante.admin.dto.CategoriasDto;
import com.restaurante.admin.entity.Categoria;
import com.restaurante.admin.entity.Producto;
import com.restaurante.admin.repository.CategoriaRepository;
import com.restaurante.admin.service.CategoriaService;
import com.restaurante.admin.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoService productoService;

    @Override
    public List<CategoriasDto> obtenerCategoriasConPlatos() {
        List<CategoriasDto> categoriasDto = new ArrayList<>();
        List<Categoria> categorias = categoriaRepository.findByEstadoIsTrue();
        for (Categoria categoria : categorias) {
            CategoriasDto categoriaDto = new CategoriasDto();
            List<Producto> productos = productoService.obtenerPlatosPorCategoriaYEstado(categoria);
            if(!productos.isEmpty()){
                categoriaDto.setNombre(categoria.getNombre());
                categoriaDto.setDescripcion(categoria.getDescripcion());
                categoriaDto.setPlatos(productos);
                categoriasDto.add(categoriaDto);
            }
        }
        return categoriasDto;
    }
    @Override
    public List<CategoriasDto> obtenerCategoriasConPlatosCompleto() {
        List<CategoriasDto> categoriasDto = new ArrayList<>();
        List<Categoria> categorias = categoriaRepository.findAll();
        for (Categoria categoria : categorias) {
            CategoriasDto categoriaDto = new CategoriasDto();
            List<Producto> productos = productoService.obtenerPlatosPorCategoria(categoria);
            if(!productos.isEmpty()){
                categoriaDto.setNombre(categoria.getNombre());
                categoriaDto.setDescripcion(categoria.getDescripcion());
                categoriaDto.setPlatos(productos);
                categoriasDto.add(categoriaDto);
            }
        }
        return categoriasDto;
    }

    @Override
    public List<CategoriasDto> obtenerCategorias() {
        List<CategoriasDto> categoriasDto = new ArrayList<>();
        List<Categoria> categorias = categoriaRepository.findByEstadoIsTrue();
        for (Categoria categoria : categorias) {
            CategoriasDto categoriaDto = new CategoriasDto();
            categoriaDto.setNombre(categoria.getNombre());
            categoriasDto.add(categoriaDto);
        }
        return categoriasDto;
    }

    public List<Categoria> obtenerCategoriasActivas() {
        return categoriaRepository.findByEstadoIsTrue();
    }
}
