package com.prueba.tenica.controllers;

import com.prueba.tenica.dto.ActualizarEstadoDTO;
import com.prueba.tenica.models.Tarea;
import com.prueba.tenica.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Obtener todas las tareas (GET)
    @GetMapping
    public List<Tarea> listarTareas() {
        return tareaService.obtenerTareas();
    }

    // Crear nueva tarea (POST)
    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaService.crearTarea(tarea, tarea.getProyecto().getId());
        return ResponseEntity.ok(nuevaTarea);
    }

    // Obtener una tarea por ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        return ResponseEntity.ok(tarea);
    }

    // Actualizar tarea existente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        tareaService.obtenerTareaPorId(id); 
        tarea.setId(id);
        Tarea tareaActualizada = tareaService.actualizarTarea(tarea);
        return ResponseEntity.ok(tareaActualizada);
    }

    // Actualizar el estado de una tarea existente (PATCH)
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Tarea> actualizarEstadoTarea(@PathVariable Long id, @RequestBody ActualizarEstadoDTO estadoDTO) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        // Convertir el valor de la cadena a un enum manualmente
        try {
            Tarea.Estado nuevoEstado = Tarea.Estado.valueOf(estadoDTO.getEstado().toUpperCase());
            tarea.setEstado(nuevoEstado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);  // Si el estado no es válido, devolver un 400
        }

        tareaService.actualizarTarea(tarea);
        return ResponseEntity.ok(tarea);
    }

    // Eliminar tarea por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }
}
