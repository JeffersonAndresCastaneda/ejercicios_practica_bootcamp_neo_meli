package com.mercadolibre.ejercicios.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class PiedraPapelTijeraTest {

    private final PiedraPapelTijera juego = new PiedraPapelTijera();

    @Test
    void piedraVenceATijera_ganaJugador1() {
        assertEquals(1, juego.jugar("piedra", "tijera"));
    }

    @Test
    void tijeraVenceAPapel() {

        assertEquals(1, juego.jugar("tijera", "papel"));
    }

    @Test
    void papelVenceAPiedra() {
        assertEquals(1, juego.jugar("papel", "piedra"));
    }


    @Test
    void jugadasIguales_esEmpate() {
        assertEquals(0, juego.jugar("papel", "papel"));
    }


    @Test
    void cuandoPierdeJugador1_ganaJugador2() {

        assertEquals(2, juego.jugar("papel", "tijera"));


    }


}
