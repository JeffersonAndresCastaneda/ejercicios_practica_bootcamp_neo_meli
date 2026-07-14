package com.example.api_rest.mapper;
import com.example.api_rest.dto.ProductoRequestDTO;
import com.example.api_rest.dto.ProductoResponseDTO;
import com.example.api_rest.model.Producto;

import java.util.List;

public class ProductoMapper {

    public ProductoMapper() {
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

    public static List<ProductoResponseDTO> toResponseList(List<Producto> productos) {
        return productos.stream().map(ProductoMapper::toResponse).toList();
    }




}
