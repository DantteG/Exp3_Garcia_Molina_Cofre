package crud_prueba_alumnos.crudalumnos.ServiceImplTest;

import crud_prueba_alumnos.crudalumnos.Alumnos.Alumnos;
import crud_prueba_alumnos.crudalumnos.ProductService.AlumnosServiceImpl;
import crud_prueba_alumnos.crudalumnos.Repository.AlumnosRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AlumnosServiceImplTest {

    @Mock
    private AlumnosRepository repository;

    @InjectMocks
    private AlumnosServiceImpl service;

    @Test
    void testFindAll() {
        Alumnos alumno = new Alumnos(1L, "Laura", "4B");
        when(repository.findAll()).thenReturn(List.of(alumno));

        List<Alumnos> result = service.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Laura", result.get(0).getNombre());
    }

    @Test
    void testFindById() {
        Alumnos alumno = new Alumnos(1L, "Pedro", "3A");
        when(repository.findById(1L)).thenReturn(Optional.of(alumno));

        Optional<Alumnos> result = service.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Pedro", result.get().getNombre());
    }

    @Test
    void testSave() {
        Alumnos alumno = new Alumnos(null, "Sofía", "1C");
        when(repository.save(alumno)).thenReturn(alumno);

        Alumnos saved = service.save(alumno);

        assertNotNull(saved);
        assertEquals("Sofía", saved.getNombre());
    }

    @Test
    void testDelete() {
        Alumnos alumno = new Alumnos(1L, "Gabriel", "1A");
        when(repository.findById(1L)).thenReturn(Optional.of(alumno));

        Optional<Alumnos> result = service.delete(alumno);

        verify(repository).delete(alumno);
        assertTrue(result.isPresent());
    }
}
