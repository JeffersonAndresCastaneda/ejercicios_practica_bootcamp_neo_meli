package com.mercadolibre.ejercicios.tdd;

/**
 * EJERCICIO 2 (TDD) - Piedra, Papel o Tijera.
 *
 * Este método está SIN implementar a propósito.
 * Construilo con TDD: primero un test que falle (rojo), después el
 * código mínimo para que pase (verde), y así con cada regla.
 *
 * Reglas:
 *   - "piedra" le gana a "tijera"
 *   - "tijera" le gana a "papel"
 *   - "papel"  le gana a "piedra"
 *   - jugadas iguales -> empate
 */
public class PiedraPapelTijera {

    /**
     * @return 0 si es empate, 1 si gana el jugador1, 2 si gana el jugador2.
     */

    public int jugar(String jugador1, String jugador2) {
        if (jugador1.equals(jugador2)) {
            return 0;
        }
        if (gana(jugador1, jugador2)) {
            return 1;
        }

        return 2;
    }

    private boolean gana(String a, String b) {
        return (a.equals("piedra") && b.equals("tijera")) || (a.equals("papel") && b.equals("piedra"))  || (a.equals("tijera") && b.equals("papel"));
    }





}
