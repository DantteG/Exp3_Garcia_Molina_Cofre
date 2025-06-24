package crud_prueba_alumnos.crudalumnos.ProductService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crud_prueba_alumnos.crudalumnos.Alumnos.Profesores.Profesores;
import crud_prueba_alumnos.crudalumnos.Repository.ProfesoresRepository;

@Service
public class ProfesoresServiceImpl implements ProfesoresService {

    @Autowired
    private ProfesoresRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Profesores> findAll() { 
        return (List<Profesores>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Profesores> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Profesores save(Profesores unProfe) {
        return repository.save(unProfe);
    }

    @Override
    @Transactional
    public Optional<Profesores> delete(Profesores unProfe) {
        Optional<Profesores> profeOptional = repository.findById(unProfe.getId());
        profeOptional.ifPresent(repository::delete);
        return profeOptional;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}