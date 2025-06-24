package crud_prueba_alumnos.crudalumnos.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crud_prueba_alumnos.crudalumnos.Alumnos.Alumnos;
import crud_prueba_alumnos.crudalumnos.Repository.AlumnosRepository;

@Service
public class AlumnosServiceImpl implements AlumnosService {

    @Autowired
    private AlumnosRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Alumnos> findAll() {
        return (List<Alumnos>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Alumnos> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Alumnos save(Alumnos alumno) {
        return repository.save(alumno);
    }

    @Override
    @Transactional
    public Optional<Alumnos> delete(Alumnos alumno) {
        Optional<Alumnos> alumnoOptional = repository.findById(alumno.getId());
        alumnoOptional.ifPresent(repository::delete);
        return alumnoOptional;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
