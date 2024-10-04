package com.prueba.tenica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.tenica.models.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
