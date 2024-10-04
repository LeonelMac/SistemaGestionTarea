package com.prueba.tenica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tenica.exceptions.DatosInvalidosException;
import com.prueba.tenica.exceptions.EstadoInvalidoException;
import com.prueba.tenica.exceptions.RecursoNoEncontradoException;
import com.prueba.tenica.models.Proyecto;
import com.prueba.tenica.models.Tarea;
import com.prueba.tenica.repositories.ProyectoRepository;
import com.prueba.tenica.repositories.TareaRepository;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    // Obtener todas las tareas
    public List<Tarea> obtenerTareas() {
        return tareaRepository.findAll();
    }

    // Obtener una tarea por ID
    public Tarea obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Tarea no encontrada"));
    }

    // Crear una tarea
    public Tarea crearTarea(Tarea tarea, Long proyectoId) {
        if (tarea.getNombre() == null || tarea.getNombre().isEmpty()) {
            throw new DatosInvalidosException("El nombre de la tarea no puede estar vacío");
        }
        if (tarea.getDescripcion() == null || tarea.getDescripcion().isEmpty()) {
            throw new DatosInvalidosException("La descripción de la tarea no puede estar vacía");
        }

        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Proyecto no encontrado"));
        
        tarea.setProyecto(proyecto);
        return tareaRepository.save(tarea);
    }

    // Actualizar una tarea
    public Tarea actualizarTarea(Tarea tarea) {
        if (tarea.getEstado() == null) {
            throw new EstadoInvalidoException("El estado de la tarea no puede ser nulo");
        }

        if (!tareaRepository.existsById(tarea.getId())) {
            throw new RecursoNoEncontradoException("Tarea no encontrada");
        }

        return tareaRepository.save(tarea);
    }

    // Actualizar solo el estado de una tarea (PATCH)
    public Tarea actualizarEstado(Long id, Tarea.Estado nuevoEstado) {
        Tarea tarea = tareaRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Tarea no encontrada"));

        tarea.setEstado(nuevoEstado);
        return tareaRepository.save(tarea);
    }

    // Eliminar una tarea
    public void eliminarTarea(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Tarea no encontrada");
        }
        tareaRepository.deleteById(id);
    }
}
