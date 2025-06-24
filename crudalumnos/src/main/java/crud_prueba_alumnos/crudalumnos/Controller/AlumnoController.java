package crud_prueba_alumnos.crudalumnos.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import crud_prueba_alumnos.crudalumnos.Alumnos.Alumnos;
import crud_prueba_alumnos.crudalumnos.ProductService.AlumnosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnosService alumnoService;

    @GetMapping
    public List<Alumnos> getAll() {
        return alumnoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Alumnos> getById(@PathVariable Long id) {
        return alumnoService.findById(id);
    }

    @PostMapping
    public Alumnos create(@RequestBody Alumnos alumno) {
        return alumnoService.save(alumno);
    }

    @PutMapping("/{id}")
    public Alumnos update(@PathVariable Long id, @RequestBody Alumnos alumno) {
        alumno.setId(id);
        return alumnoService.save(alumno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        alumnoService.deleteById(id);
    }
}