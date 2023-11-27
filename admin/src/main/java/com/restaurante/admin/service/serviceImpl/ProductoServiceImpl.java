package com.restaurante.admin.service.serviceImpl;

import com.restaurante.admin.entity.Categoria;
import com.restaurante.admin.entity.Producto;
import com.restaurante.admin.repository.ProductoRepository;
import com.restaurante.admin.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerPlatosPorCategoriaYEstado(Categoria categoria) {
        return productoRepository.findByCategoriaAndEstadoIsTrue(categoria);
    }

    public List<Producto> obtenerPlatosPorCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    @Override
    public List<Producto> obtenerPlatos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPlatoPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto CrearPlato(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List <Producto> CrearPlatos(List<Producto> productos) {
        return productoRepository.saveAll(productos);
    }

    @Override
    public Producto ActualizarPlato(Long id, Producto producto) {
        if (productoRepository.existsById(id)) {
            producto.setId(id);
            return productoRepository.save(producto);
        }
        return null;
    }

    @Override
    public void EliminarPlato(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto ModificarDisponibilidadPlato(Long id) {
        Optional<Producto> optionalPlato = productoRepository.findById(id);
        if (optionalPlato.isPresent()) {
            Producto producto = optionalPlato.get();
            producto.setEstado(!producto.getEstado()); // Cambiar el estado
            return productoRepository.save(producto);
        }
        return null;
    }

}
