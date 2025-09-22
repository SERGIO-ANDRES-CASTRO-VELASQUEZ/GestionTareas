package com.trabajo.gestiontareas.controller;

import com.trabajo.gestiontareas.entity.Tarea;
import com.trabajo.gestiontareas.entity.enums.Estado;
import com.trabajo.gestiontareas.service.TareaService;
import com.trabajo.gestiontareas.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaService.crearTarea(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> listarOTraerFiltradas(

            @RequestParam(required = false) Estado estado,
            @RequestParam(required = false) LocalDate antesDe) {

        List<Tarea> tareas;

        if (estado != null) {
            tareas = tareaService.filtrarPorEstado(estado);
        } else if (antesDe != null) {
            tareas = tareaService.filtrarFechaVencimiento(antesDe);
        } else {
            tareas = tareaService.listarTareas();
        }
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) {
        Tarea tarea = tareaService.obtenerTareaPorId(id);
        if (tarea == null) {
            throw new EntityNotFoundException("Id no encontrado " + id);
        }
        return ResponseEntity.ok(tarea);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tareaDetails) {
        Tarea tareaActualizada = tareaService.actualizarTarea(id, tareaDetails);
        return ResponseEntity.ok(tareaActualizada);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }
}