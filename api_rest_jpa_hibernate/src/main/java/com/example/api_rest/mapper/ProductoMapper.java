package com.example.api_rest.mapper;

import com.example.api_rest.dto.ProductoRequestDTO;
import com.example.api_rest.dto.ProductoResponseDTO;
import com.example.api_rest.model.Producto;

import java.util.List;

// Clase "traductora" entre DTOs (lo que entra/sale por la API)
// y la entidad Producto (lo que se persiste en la base de datos).
// No guarda estado ni depende de Spring: son solo metodos estaticos.
public class ProductoMapper {

    private ProductoMapper() {
        // Evita que alguien haga "new ProductoMapper()": no tiene sentido,
        // todos sus metodos son estaticos.
    }

    public static Producto toEntity(ProductoRequestDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setPrecio(dto.getPrecio());
        return p;
    }

    public static ProductoResponseDTO toResponse(Producto p) {
        return new ProductoResponseDTO(p.getId(), p.getNombre(), p.getPrecio());
    }

    // Util para el listado: convierte cada elemento de la lista de entidades
    // en su version DTO, usando toResponse() de arriba.
    public static List<ProductoResponseDTO> toResponseList(List<Producto> productos) {
        return productos.stream()
                .map(ProductoMapper::toResponse)
                .toList();
    }
}
