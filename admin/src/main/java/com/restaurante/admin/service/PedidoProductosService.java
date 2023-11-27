package com.restaurante.admin.service;

import com.restaurante.admin.entity.Pedido;
import com.restaurante.admin.entity.PedidoProductos;

import java.util.List;

public interface PedidoProductosService {

    List<PedidoProductos> crearPedidoProductos(List<PedidoProductos> pedidoProductos, Pedido pedido);

}
