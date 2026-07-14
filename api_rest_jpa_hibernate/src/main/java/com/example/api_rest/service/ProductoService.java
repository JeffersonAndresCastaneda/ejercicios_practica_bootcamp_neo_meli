package com.example.api_rest.service;

import com.example.api_rest.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> listarTodos();
    Optional<Producto> buscarPorId(Long id);
    Producto crearProducto (Producto producto);
    Optional<Producto> actualizarProducto (Long id,Producto productoActualizado);
    boolean borrarProducto (Long id);
    }



