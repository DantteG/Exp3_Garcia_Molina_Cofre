package crud_prueba_alumnos.crudalumnos.Repository;

import crud_prueba_alumnos.crudalumnos.Alumnos.Profesores.Profesores;
import org.springframework.data.repository.CrudRepository;


public interface ProfesoresRepository extends CrudRepository<Profesores, Long> {
}