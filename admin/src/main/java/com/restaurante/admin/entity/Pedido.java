package com.restaurante.admin.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pedido", nullable = false)
    private Long id;

    private Date fecha;
    private String estado;



    private Double total;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PedidoProductos> pedidoProductosList;

    @Override
    public String toString() {
        return "MENSAJE PARA EL CLIENTE: Pedido numero: " + id +
                ", total a pagar de : " + total ;
    }

}
