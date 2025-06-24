package crud_prueba_alumnos.crudalumnos.ProductService;

import java.util.List;
import java.util.Optional;

import crud_prueba_alumnos.crudalumnos.Alumnos.Profesores.Profesores;

public interface ProfesoresService {
    List<Profesores> findAll(); // ✅ nombre correcto
    Optional<Profesores> findById(Long id);
    Profesores save(Profesores unProfe);
    Optional<Profesores> delete(Profesores unProfe);
    void deleteById(Long id);
}