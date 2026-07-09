package com.example.api_rest.dto;

// Lo que la API devuelve al cliente. Si lleva "id", porque el cliente
// necesita saber que identificador le asigno la base de datos.
public class ProductoResponseDTO {

    private Long id;
    private String nombre;
    private double precio;

    public ProductoResponseDTO() {
    }

    public ProductoResponseDTO(Long id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
