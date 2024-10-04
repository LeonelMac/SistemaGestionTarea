package com.prueba.tenica.controllers;

import com.prueba.tenica.models.Proyecto;
import com.prueba.tenica.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    // Obtener todos los proyectos (GET)
    @GetMapping
    public List<Proyecto> listarProyectos() {
        return proyectoService.obtenerProyectos();
    }

    // Crear un nuevo proyecto (POST)
    @PostMapping
    public ResponseEntity<Proyecto> crearProyecto(@RequestBody Proyecto proyecto) {
        Proyecto nuevoProyecto = proyectoService.crearProyecto(proyecto);
        return new ResponseEntity<>(nuevoProyecto, HttpStatus.CREATED);
    }

    // Obtener un proyecto por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id) {
        Proyecto proyecto = proyectoService.obtenerProyectoPorId(id);
        return ResponseEntity.ok(proyecto);
    }

    // Actualizar un proyecto existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        Proyecto proyectoExistente = proyectoService.obtenerProyectoPorId(id);
        proyectoExistente.setNombre(proyecto.getNombre());
        proyectoService.crearProyecto(proyectoExistente); 
        return ResponseEntity.ok(proyectoExistente);
    }

    // Eliminar proyecto por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.noContent().build();
    }
}
