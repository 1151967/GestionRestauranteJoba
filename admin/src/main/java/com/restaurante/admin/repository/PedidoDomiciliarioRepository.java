package com.restaurante.admin.repository;

import com.restaurante.admin.entity.PedidoDomiciliario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface PedidoDomiciliarioRepository extends JpaRepository<PedidoDomiciliario, Long> {
}
