package com.mercadolibre.ejercicios.dados;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class JuegoDeDadosTest {

    @Mock
    Aleatorio aleatorio;
    @InjectMocks
    JuegoDeDados juego;

    @Test
    void tirar_devuelveLoQueDaElAleatorio() {
        // Arrange: cuando pidan entre(1,6), devolvé 4
        when(aleatorio.entre(1, 6)).thenReturn(4);

        // Act
        int resultado = juego.tirar();

        // Assert
        assertEquals(4, resultado);
        verify(aleatorio).entre(1, 6);   // verificamos la interacción
    }

    @Test
    void esGanador_cuandoSaleSeis_devuelveTrue() {
       when(aleatorio.entre(1, 6)).thenReturn(6);
       JuegoDeDados juegoDeDados = new JuegoDeDados(aleatorio);
       assertTrue(juegoDeDados.esGanador());



    }


    @Test
    void esGanador_cuandoNoSaleSeis_devuelveFalse() {

        when(aleatorio.entre(1, 6)).thenReturn(3);
        JuegoDeDados juegoDeDados = new JuegoDeDados(aleatorio);
        assertFalse(juegoDeDados.esGanador());


    }
}
