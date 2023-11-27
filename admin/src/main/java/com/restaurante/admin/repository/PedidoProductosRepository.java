package com.restaurante.admin.repository;

import com.restaurante.admin.entity.PedidoProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoProductosRepository extends JpaRepository<PedidoProductos, Long> {

}
