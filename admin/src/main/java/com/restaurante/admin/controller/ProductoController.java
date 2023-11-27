package com.restaurante.admin.controller;

import com.restaurante.admin.entity.Producto;
import com.restaurante.admin.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> getAllPlatos() {
        List<Producto> productos = productoService.obtenerPlatos();
        return ResponseEntity.ok(productos); // Código de estado 200 y lista de productos
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getPlato(@PathVariable Long id) {
        Optional<Producto> plato = Optional.ofNullable(productoService.obtenerPlatoPorId(id));
        return plato.map(ResponseEntity::ok) // Código de estado 200 y plato si existe
                .orElse(ResponseEntity.notFound().build()); // Código de estado 404 si no se encontró el plato
    }

    @PostMapping
    public ResponseEntity<Producto> createPlato(@RequestBody Producto producto) {
        Producto creado = productoService.CrearPlato(producto);
        return ResponseEntity.status(201).body(creado); // Código de estado 201 y producto creado
    }
    @PostMapping("/masivo")
    public ResponseEntity<List<Producto>> createPlatoMasivo(@RequestBody List<Producto> producto) {
        List<Producto> creado = productoService.CrearPlatos(producto);
        return ResponseEntity.status(201).body(creado); // Código de estado 201 y producto creado
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updatePlato(@PathVariable Long id, @RequestBody Producto producto) {
        Producto actualizado = productoService.ActualizarPlato(id, producto);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado); // Código de estado 200 y producto actualizado
        } else {
            return ResponseEntity.notFound().build(); // Código de estado 404 si no se encontró el producto
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlato(@PathVariable Long id) {
        productoService.EliminarPlato(id);
        return ResponseEntity.noContent().build(); // Código de estado 204 (No Content) para indicar éxito sin contenido
    }

    @PutMapping("/{id}/disponibilidad")
    public ResponseEntity<Producto> updateDisponibilidadPlato(@PathVariable Long id) {
        Producto actualizado = productoService.ModificarDisponibilidadPlato(id);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado); // Código de estado 200 y plato actualizado
        } else {
            return ResponseEntity.notFound().build(); // Código de estado 404 si no se encontró el plato
        }
    }
}
