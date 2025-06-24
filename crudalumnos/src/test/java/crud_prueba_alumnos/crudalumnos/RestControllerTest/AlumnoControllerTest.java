package crud_prueba_alumnos.crudalumnos.RestControllerTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import crud_prueba_alumnos.crudalumnos.Alumnos.Alumnos;
import crud_prueba_alumnos.crudalumnos.ProductService.AlumnosService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import crud_prueba_alumnos.crudalumnos.Controller.AlumnoController;

@WebMvcTest(AlumnoController.class) // Especificar el controlador a testear

@AutoConfigureMockMvc
public class AlumnoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // Se cambia @Autowired por @MockBean para mockear el servicio
    @MockBean
    private AlumnosService alumnoService;

    @Test
    void testGetAllAlumnos() throws Exception {
        Alumnos alumno = new Alumnos(1L, "Laura", "Matemática");
        when(alumnoService.findAll()).thenReturn(Arrays.asList(alumno));

        mockMvc.perform(get("/api/alumnos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Laura"));
    }

    @Test
    void testGetAlumnoById() throws Exception {
        Alumnos alumno = new Alumnos(2L, "Carlos", "Historia");
        when(alumnoService.findById(2L)).thenReturn(Optional.of(alumno));

        mockMvc.perform(get("/api/alumnos/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Carlos"));
    }

   @Test
    void testCreateAlumno() throws Exception {
        Alumnos alumno = new Alumnos(null, "María", "Física");
        Alumnos saved = new Alumnos(3L, "María", "Física");
        when(alumnoService.save(any(Alumnos.class))).thenReturn(saved);
        mockMvc.perform(post("/api/alumnos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(alumno)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("María"));
    }
}