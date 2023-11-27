package com.restaurante.admin.controller;

import com.restaurante.admin.entity.Pedido;
import com.restaurante.admin.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido nuevoPedido) {
        Pedido pedidoGuardado = pedidoService.crearPedido(nuevoPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoGuardado);
    }
}
