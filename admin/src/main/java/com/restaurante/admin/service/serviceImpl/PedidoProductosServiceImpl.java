package com.restaurante.admin.service.serviceImpl;

import com.restaurante.admin.entity.Pedido;
import com.restaurante.admin.entity.PedidoProductos;
import com.restaurante.admin.repository.PedidoProductosRepository;
import com.restaurante.admin.service.PedidoProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoProductosServiceImpl implements PedidoProductosService {

    @Autowired
    private PedidoProductosRepository pedidoProductosRepository;

    @Override
    public List<PedidoProductos> crearPedidoProductos(List<PedidoProductos> pedidoProductosList,Pedido pedido) {
        pedidoProductosList.forEach(pedidoProducto -> pedidoProducto.setPedido(pedido));
        return pedidoProductosRepository.saveAll(pedidoProductosList);
    }

}
