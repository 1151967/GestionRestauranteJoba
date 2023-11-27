package com.restaurante.admin.dto;

import java.util.Date;
import java.util.List;

public class Menu {

    private Date fechaHoy;
    private List<CategoriasDto> categoriasDisponibles;

    public Date getFechaHoy() {
        fechaHoy = new Date();
        return fechaHoy;
    }
    public List<CategoriasDto> getCategoriasDisponibles() {
        return categoriasDisponibles;
    }

    public void setCategoriasDisponibles(List<CategoriasDto> categoriasDisponibles) {
        this.categoriasDisponibles = categoriasDisponibles;
    }
}
