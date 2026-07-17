package com.example.api_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private BigDecimal precio;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto p)) return false;
        return id != null && id.equals(p.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
