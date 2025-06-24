package crud_prueba_alumnos.crudalumnos.RestControllerTest;


import com.fasterxml.jackson.databind.ObjectMapper;
import crud_prueba_alumnos.crudalumnos.Alumnos.Profesores.Profesores;
import crud_prueba_alumnos.crudalumnos.ProductService.ProfesoresService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; 
import org.springframework.boot.test.mock.mockito.MockBean; 
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import crud_prueba_alumnos.crudalumnos.Controller.ProfesorController;

@WebMvcTest(ProfesorController.class)
@AutoConfigureMockMvc
public class ProfesorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProfesoresService profesoresService;

    @Test
    void testGetAllProfesores() throws Exception {
        Profesores profe = new Profesores(1L, "Ana", "López", "Lenguaje");
        when(profesoresService.findAll()).thenReturn(Arrays.asList(profe));

        mockMvc.perform(get("/api/profesores"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Ana"));
    }

    @Test
    void testGetProfesorById() throws Exception {
        Profesores profe = new Profesores(2L, "Mario", "Sánchez", "Arte");
        when(profesoresService.findById(2L)).thenReturn(Optional.of(profe));

        mockMvc.perform(get("/api/profesores/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Mario"));
    }

    @Test
    void testCreateProfesor() throws Exception {
        Profesores input = new Profesores(null, "Luis", "Castro", "Biología");
        Profesores saved = new Profesores(3L, "Luis", "Castro", "Biología");
        when(profesoresService.save(any(Profesores.class))).thenReturn(saved);
        mockMvc.perform(post("/api/profesores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Luis"));
    }
}