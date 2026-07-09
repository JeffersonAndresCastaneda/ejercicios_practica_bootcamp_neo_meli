package com.example.api_rest.service;

import com.example.api_rest.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final List<Producto> productos = new ArrayList<>();
    private long contadorId = 0;


    public List<Producto> listarTodos() {
        return productos;

    }

    public Optional<Producto> buscarPorId(Long id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }



    public Producto crearProducto(Producto producto) {
        producto.setId(++contadorId);
        productos.add(producto);
        return producto;
    }


     public Optional<Producto> actualizarProducto (Long id,Producto productoActualizado){
        return buscarPorId(id)
                .map(productoExistente-> {
                    productoExistente.setNombre(productoActualizado.getNombre());
                    productoExistente.setPrecio(productoActualizado.getPrecio());
                    return productoExistente;
                });
    }


        public boolean borrarProducto (Long id){
        return productos.removeIf(p-> p.getId().equals(id));

    }

}



