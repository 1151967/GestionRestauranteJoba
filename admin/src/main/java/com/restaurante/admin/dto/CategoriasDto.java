package com.restaurante.admin.dto;
import com.restaurante.admin.entity.Producto;

import java.util.List;

public class CategoriasDto {
    private String nombre;

    private String descripcion;

    private List<Producto> productos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getPlatos() {
        return productos;
    }

    public void setPlatos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
