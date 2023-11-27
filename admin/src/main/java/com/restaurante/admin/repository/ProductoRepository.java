package com.restaurante.admin.repository;

import com.restaurante.admin.entity.Categoria;
import com.restaurante.admin.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoriaAndEstadoIsTrue(Categoria categoria);

    List<Producto> findByCategoria(Categoria categoria);

}
