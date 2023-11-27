package com.restaurante.admin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "domiciliario")
@Data
public class Domiciliario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_domiciliario", nullable = false)
    private Long id;

    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private Boolean disponible;

}
