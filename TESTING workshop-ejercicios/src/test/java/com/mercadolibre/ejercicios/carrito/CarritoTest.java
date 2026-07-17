package com.mercadolibre.ejercicios.carrito;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


class CarritoTest {


    @Test
    void carritoNuevo_estaVacio() {
        // Arrange
        Carrito carrito = new Carrito();

        // Act + Assert
        assertTrue(carrito.estaVacio());
        assertEquals(0, carrito.total());
    }


    @Test
    void agregarDosProductos_cantidadEsDos() {
                Carrito carrito = new Carrito();
                carrito.agregar(100);
                carrito.agregar(50);
                assertEquals(2, carrito.cantidad());


    }


    @Test
    void total_sumaLosPrecios() {
            Carrito carrito = new Carrito();
            carrito.agregar(100);
            carrito.agregar(50);
            assertEquals(150, carrito.total());
    }




    @Test
    void totalConDescuento_aplicaElPorcentaje() {
        Carrito carrito = new Carrito();
        carrito.agregar(200);
        int cantidadDescuento = carrito.totalConDescuento(25);
        assertEquals(150,cantidadDescuento );


    }


    @Test
    void agregarPrecioNegativo_lanzaExcepcion() {
        Carrito carrito = new Carrito();
        assertThrows(IllegalArgumentException.class, () -> carrito.agregar(-10));
    }





    @Test
    void descuentoInvalido_lanzaExcepcion() {
        Carrito carrito = new Carrito();
        assertThrows(IllegalArgumentException.class, () -> carrito.totalConDescuento(150));
    }


}
