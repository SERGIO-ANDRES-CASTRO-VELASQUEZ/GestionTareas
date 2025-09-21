package com.trabajo.gestiontareas.repository;

import com.trabajo.gestiontareas.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepo extends JpaRepository<Tarea, Long> {
}
