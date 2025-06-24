package crud_prueba_alumnos.crudalumnos.Repository;

import org.springframework.data.repository.CrudRepository;
import crud_prueba_alumnos.crudalumnos.Alumnos.Alumnos;

public interface AlumnosRepository extends CrudRepository<Alumnos, Long> {
}