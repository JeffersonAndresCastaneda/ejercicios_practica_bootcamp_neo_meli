package com.example.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductoRequestDTO(
        @NotBlank(message = "el nombre es obligatorio")
        String nombre,

        @Positive(message = "el precio debe ser un numero mayor que 0")
        BigDecimal precio
) {
}
