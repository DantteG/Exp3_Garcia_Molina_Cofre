package crud_prueba_alumnos.crudalumnos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import crud_prueba_alumnos.crudalumnos.Alumnos.Profesores.Profesores;
import crud_prueba_alumnos.crudalumnos.ProductService.ProfesoresService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesoresService profesoresService;

    @GetMapping
    public List<Profesores> getAll() {
        return profesoresService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Profesores> getById(@PathVariable Long id) {
        return profesoresService.findById(id);
    }

    @PostMapping
    public Profesores create(@RequestBody Profesores profesor) {
        return profesoresService.save(profesor);
    }

    @PutMapping("/{id}")
    public Profesores update(@PathVariable Long id, @RequestBody Profesores profesor) {
        profesor.setId(id);
        return profesoresService.save(profesor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        profesoresService.deleteById(id);
    }
}