package com.example.api_rest.service;

import com.example.api_rest.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listarTodos();
    Producto buscarPorId(Long id);
    Producto crearProducto (Producto producto);
    Producto actualizarProducto (Long id,Producto productoActualizado);
    void borrarProducto (Long id);
    }



