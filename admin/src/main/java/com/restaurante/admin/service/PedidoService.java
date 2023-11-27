package com.restaurante.admin.service;

import com.restaurante.admin.entity.Pedido;

public interface PedidoService {

    Pedido crearPedido(Pedido pedido);

    Pedido obtenerPedido(Long id);

    Pedido actualizarPedido(Pedido pedido);

    void eliminarPedido(Long id);


}
