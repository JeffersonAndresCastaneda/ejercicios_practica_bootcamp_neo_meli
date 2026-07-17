package com.mercadolibre.ejercicios.tareas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TareaController.class)
class TareaControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    TareaService service;


    @Test
    void GET_tareas_devuelve200yLaLista() throws Exception {
        when(service.listar()).thenReturn(List.of(
                new Tarea(1L, "Escribir mi primer test", true)
        ));

        mvc.perform(get("/tareas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Escribir mi primer test"))
                .andExpect(jsonPath("$[0].completada").value(true));
    }


    @Test
    void GET_tareasPendientes_usaListarPendientes() throws Exception {
        when(service.listarPendientes()).thenReturn(List.of(
                new Tarea(2L, "Aprender Mockito", false)
        ));

        mvc.perform(get("/tareas").param("pendientes", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Aprender Mockito"))
                .andExpect(jsonPath("$[0].completada").value(false));
    }
}
