package com.restaurante.admin.service;

import com.restaurante.admin.entity.Categoria;
import com.restaurante.admin.entity.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> obtenerPlatosPorCategoriaYEstado(Categoria categoria);

    List<Producto> obtenerPlatosPorCategoria(Categoria categoria);

    List<Producto> obtenerPlatos();

    Producto obtenerPlatoPorId(Long id);

    Producto CrearPlato(Producto producto);

    List <Producto> CrearPlatos(List<Producto> productos);

    Producto ActualizarPlato(Long id, Producto producto);

    void EliminarPlato(Long id);

    Producto ModificarDisponibilidadPlato(Long id);


}
