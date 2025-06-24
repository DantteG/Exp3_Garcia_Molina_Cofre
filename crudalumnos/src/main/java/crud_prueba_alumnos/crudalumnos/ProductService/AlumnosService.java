package crud_prueba_alumnos.crudalumnos.ProductService;

import java.util.List;
import java.util.Optional;
import crud_prueba_alumnos.crudalumnos.Alumnos.Alumnos;

public interface AlumnosService {
    List<Alumnos> findAll();
    Optional<Alumnos> findById(Long id);
    Alumnos save(Alumnos alumno);
    Optional<Alumnos> delete(Alumnos alumno);
    void deleteById(Long id);
}
