package com.mercadolibre.ejercicios.carrito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * EJERCICIO 1 (JUnit 5).
 * El primer test ya está resuelto como ejemplo. Completá los demás.
 * Recordá el patrón Arrange - Act - Assert.
 */
class CarritoTest {

    // ===== EJEMPLO RESUELTO =====
    @Test
    void carritoNuevo_estaVacio() {
        // Arrange
        Carrito carrito = new Carrito();

        // Act + Assert
        assertTrue(carrito.estaVacio());
        assertEquals(0, carrito.total());
    }

    // ===== TODO 1: al agregar 2 productos, la cantidad es 2 y ya no está vacío =====
    @Test
    void agregarDosProductos_cantidadEsDos() {
                Carrito carrito = new Carrito();
                carrito.agregar(100);
                carrito.agregar(50);
                assertEquals(2, carrito.cantidad());


    }


    // ===== TODO 2: agregar 100 y 50 -> total() debe ser 150 =====
    @Test
    void total_sumaLosPrecios() {
            Carrito carrito = new Carrito();
            carrito.agregar(100);
            carrito.agregar(50);
            assertEquals(150, carrito.total());
    }




    // ===== TODO 3: total 200 con 25% de descuento -> 150 =====
    @Test
    void totalConDescuento_aplicaElPorcentaje() {
        Carrito carrito = new Carrito();
        carrito.agregar(200);
        int cantidadDescuento = carrito.totalConDescuento(25);
        assertEquals(150,cantidadDescuento );


    }


    // ===== TODO 4: agregar un precio negativo lanza IllegalArgumentException =====
    // Pista: assertThrows(IllegalArgumentException.class, () -> carrito.agregar(-10));
    @Test
    void agregarPrecioNegativo_lanzaExcepcion() {
        Carrito carrito = new Carrito();
        assertThrows(IllegalArgumentException.class, () -> carrito.agregar(-10));
    }





    // ===== TODO 5 (extra): un porcentaje de descuento mayor a 100 lanza excepción =====
    @Test
    void descuentoInvalido_lanzaExcepcion() {
        Carrito carrito = new Carrito();
        assertThrows(IllegalArgumentException.class, () -> carrito.totalConDescuento(150));
    }


}
