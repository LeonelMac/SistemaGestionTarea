package com.prueba.tenica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tenica.exceptions.DatosInvalidosException;
import com.prueba.tenica.exceptions.RecursoNoEncontradoException;
import com.prueba.tenica.models.Proyecto;
import com.prueba.tenica.repositories.ProyectoRepository;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    // Obtener todos los proyectos
    public List<Proyecto> obtenerProyectos() {
        return proyectoRepository.findAll();
    }

    // Obtener un proyecto por ID
    public Proyecto obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Proyecto no encontrado"));
    }

    // Crear o actualizar un proyecto
    public Proyecto crearProyecto(Proyecto proyecto) {
        if (proyecto.getNombre() == null || proyecto.getNombre().isEmpty()) {
            throw new DatosInvalidosException("El nombre del proyecto no puede estar vacío");
        }
        return proyectoRepository.save(proyecto);
    }

    // Eliminar un proyecto
    public void eliminarProyecto(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Proyecto no encontrado"));

        if (!proyecto.getTareas().isEmpty()) {
            throw new IllegalStateException("No se puede eliminar un proyecto que tiene tareas asociadas.");
        }
        proyectoRepository.delete(proyecto);
    }
}
