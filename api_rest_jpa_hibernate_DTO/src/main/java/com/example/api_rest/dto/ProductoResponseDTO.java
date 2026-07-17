package com.example.api_rest.dto;

import java.math.BigDecimal;

public record ProductoResponseDTO(
        Long id,
        String nombre,
        BigDecimal precio
) {
}
