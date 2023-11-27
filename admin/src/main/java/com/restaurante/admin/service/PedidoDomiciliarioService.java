package com.restaurante.admin.service;

import com.restaurante.admin.entity.Pedido;
import com.restaurante.admin.entity.PedidoDomiciliario;

public interface PedidoDomiciliarioService {

    PedidoDomiciliario asignarDomiciliario(Pedido pedido);
}
