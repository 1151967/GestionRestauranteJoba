package com.restaurante.admin.service.serviceImpl;

import com.restaurante.admin.Util;
import com.restaurante.admin.entity.Domiciliario;
import com.restaurante.admin.entity.Pedido;
import com.restaurante.admin.entity.PedidoDomiciliario;
import com.restaurante.admin.repository.PedidoDomiciliarioRepository;
import com.restaurante.admin.service.PedidoDomiciliarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoDomiciliarioServiceImpl implements PedidoDomiciliarioService {

    @Autowired
    private PedidoDomiciliarioRepository pedidoDomiciliarioRepository;

    @Autowired
    private Util util;

    @Override
    public PedidoDomiciliario asignarDomiciliario(Pedido pedido) {
        PedidoDomiciliario pedidoDomiciliario = new PedidoDomiciliario();
        pedidoDomiciliario.setPedido(pedido);
        Domiciliario domiciliario = new Domiciliario();
        domiciliario.setId(1L);
        pedidoDomiciliario.setDomiciliario(domiciliario);
        EnviarMensajeDomiciliario(pedido.getId(),pedido.getTotal().toString());
        return pedidoDomiciliarioRepository.save(pedidoDomiciliario);

    }

    private void EnviarMensajeDomiciliario(Long id, String total){
        String mensaje = "MENSAJE PARA EL DOMICILIARIO: Tienes una nueva entrega, Recojelo con el numero de pedido: "+ id+ " y recuerda que el cliente debe pagar:  "+total+" pesos";
        util.EnviarMensaje(mensaje,"+573052427551");
    }
}
