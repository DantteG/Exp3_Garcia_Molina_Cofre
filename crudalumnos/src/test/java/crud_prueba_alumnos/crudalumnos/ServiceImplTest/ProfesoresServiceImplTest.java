package crud_prueba_alumnos.crudalumnos.ServiceImplTest;

import crud_prueba_alumnos.crudalumnos.Alumnos.Profesores.Profesores;
import crud_prueba_alumnos.crudalumnos.ProductService.ProfesoresServiceImpl;
import crud_prueba_alumnos.crudalumnos.Repository.ProfesoresRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProfesoresServiceImplTest {

    @Mock
    private ProfesoresRepository repository;

    @InjectMocks
    private ProfesoresServiceImpl service;

    @Test
    void testFindByAll() {
        Profesores profe = new Profesores(1L, "Juan", "Pérez", "Matemática");
        when(repository.findAll()).thenReturn(List.of(profe));

        List<Profesores> result = service.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Juan", result.get(0).getNombre());
    }

    @Test
    void testFindById() {
        Profesores profe = new Profesores(1L, "Carlos", "Gómez", "Historia");
        when(repository.findById(1L)).thenReturn(Optional.of(profe));

        Optional<Profesores> result = service.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Carlos", result.get().getNombre());
    }

    @Test
    void testSave() {
        Profesores profe = new Profesores(null, "Luis", "Soto", "Química");
        when(repository.save(profe)).thenReturn(profe);

        Profesores saved = service.save(profe);

        assertNotNull(saved);
        assertEquals("Luis", saved.getNombre());
    }

    @Test
    void testDelete() {
        Profesores profe = new Profesores(1L, "Pedro", "Martínez", "Física");
        when(repository.findById(1L)).thenReturn(Optional.of(profe));

        Optional<Profesores> result = service.delete(profe);

        verify(repository).delete(profe);
        assertTrue(result.isPresent());
    }
}
