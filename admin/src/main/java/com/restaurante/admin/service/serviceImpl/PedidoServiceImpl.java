package com.restaurante.admin.service.serviceImpl;

import com.restaurante.admin.Util;
import com.restaurante.admin.entity.Pedido;
import com.restaurante.admin.entity.PedidoProductos;
import com.restaurante.admin.entity.Producto;
import com.restaurante.admin.repository.PedidoRepository;
import com.restaurante.admin.service.PedidoDomiciliarioService;
import com.restaurante.admin.service.PedidoProductosService;
import com.restaurante.admin.service.PedidoService;
import com.restaurante.admin.service.ProductoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoProductosService productoService;

    @Autowired
    private PedidoDomiciliarioService asignar;

    @Autowired
    private ProductoService productoService2;

    @Autowired
    private Util util;

    @Override
    @Transactional
    public Pedido crearPedido(Pedido pedido) {
        pedido.setFecha(new Date());
        pedido.setEstado("ASIGNADO");
        Pedido pedidoGuardado = pedidoRepository.save(pedido);
        List<PedidoProductos> lista =  productoService.crearPedidoProductos(pedido.getPedidoProductosList(), pedidoGuardado);
        pedidoGuardado.setPedidoProductosList(lista);
        util.EnviarMensaje(pedidoGuardado.toString(),"+573052427551");

        EnviarMensajeDeLaCocina(pedidoGuardado);
        asignar.asignarDomiciliario(pedidoGuardado);
        return pedidoGuardado;
    }

    private void EnviarMensajeDeLaCocina(Pedido pedidoGuardado) {
        String mensajeConDetalles = "Pedido No. "+ pedidoGuardado.getId();
        List<PedidoProductos> pedidoProductosList = pedidoGuardado.getPedidoProductosList();
        for (PedidoProductos pedidoProductos : pedidoProductosList) {
            Producto producto = productoService2.obtenerPlatoPorId(pedidoProductos.getProducto().getId());
            mensajeConDetalles += "\n"+producto.getNombre()+" x "+pedidoProductos.getCantidad();
        }

        util.EnviarMensaje(mensajeConDetalles,"+573052427551");

    }

    @Override
    public Pedido obtenerPedido(Long id) {
        return null;
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        return null;
    }

    @Override
    public void eliminarPedido(Long id) {

    }
}
