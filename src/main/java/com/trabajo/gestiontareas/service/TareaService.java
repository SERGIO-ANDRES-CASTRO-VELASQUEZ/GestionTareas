package com.trabajo.gestiontareas.service;

import com.trabajo.gestiontareas.entity.Tarea;
import com.trabajo.gestiontareas.entity.enums.Estado;
import com.trabajo.gestiontareas.repository.TareaRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {
    @Autowired
    private TareaRepo repo;

    public List<Tarea> listarTareas() {
        return repo.findAll();
    }

    public Tarea crearTarea (Tarea tarea) {
        return repo.save(tarea);
    }

    public Tarea actualizarTarea(Long id, Tarea tareaActualizada){
        Optional<Tarea> tarea = repo.findById(id);

        if (tarea.isPresent()) {
            Tarea tareaDb = tarea.get();
            tareaDb.setTitulo(tareaActualizada.getTitulo());
            tareaDb.setDescripcion(tareaActualizada.getDescripcion());
            tareaDb.setFechaVencimiento(tareaActualizada.getFechaVencimiento());
            tareaDb.setPrioridad(tareaActualizada.getPrioridad());
            tareaDb.setEstado(tareaActualizada.getEstado());
            return repo.save(tareaDb);
        } else {
            throw new EntityNotFoundException("Tarea no encontrada para actualizar.");
        }
    }

    public Tarea obtenerTareaPorId(Long id) {
        Tarea tarea = repo.findById(id).orElse(null);
        if (tarea == null) {
            throw new EntityNotFoundException("Id no encontrado " + id);
        }
        return tarea;
    }

    public void eliminarTarea(Long id) {
        if (!repo.existsById(id)) {
            throw new EntityNotFoundException("Tarea no encontrada para eliminar.");
        }
        repo.deleteById(id);
    }

    //casos para mi jajaja
    public List<Tarea> filtrarPorEstado(Estado estado) {
        return repo.findByEstado(estado);
    }

    public List<Tarea> filtrarAntesDeFechaVencimiento(LocalDate fecha) {
        return repo.findByFechaVencimientoBefore(fecha);
    }
}
