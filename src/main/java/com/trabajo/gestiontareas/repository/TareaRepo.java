package com.trabajo.gestiontareas.repository;

import com.trabajo.gestiontareas.entity.Tarea;
import com.trabajo.gestiontareas.entity.enums.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TareaRepo extends JpaRepository<Tarea, Long> {
    List<Tarea> findByEstado(Estado estado);
    List<Tarea> findByFechaVencimiento(LocalDate fechaVencimiento);
}
