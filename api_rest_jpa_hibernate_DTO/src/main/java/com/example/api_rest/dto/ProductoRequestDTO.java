package com.example.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProductoRequestDTO
{
@NotBlank(message = "el nombre es obligatorio")
private String nombre;

@Positive(message = " el precio debe ser un numero mayor que 0")
private double precio;

    public ProductoRequestDTO(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public ProductoRequestDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
