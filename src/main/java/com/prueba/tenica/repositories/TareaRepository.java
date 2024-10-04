package com.prueba.tenica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.tenica.models.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
