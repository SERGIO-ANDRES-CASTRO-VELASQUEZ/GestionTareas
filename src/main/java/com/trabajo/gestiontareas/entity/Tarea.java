package com.trabajo.gestiontareas.entity;

import com.trabajo.gestiontareas.entity.enums.Estado;
import com.trabajo.gestiontareas.entity.enums.Prioridad;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name ="tabla_tareas")
public class Tarea {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false, length = 255)
    private String descripcion;
    @Column(nullable = false)
    private LocalDate fechaVencimiento;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Prioridad prioridad;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado estado;
    @Column(nullable = false)
    private LocalDateTime creadaEn = LocalDateTime.now();

    //Constructor vacio
    public Tarea() {

    }
    //Constructor con parametros

    public Tarea(String titulo, String descripcion, LocalDate fechaVencimiento, Prioridad prioridad, Estado estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
        this.estado = estado;
    }

    //Getters y Setters
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDateTime getCreadaEn() {
        return creadaEn;
    }

    //ToString
    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaVencimiento=" + fechaVencimiento +
                ", prioridad=" + prioridad +
                ", estado=" + estado +
                ", creadaEn=" + creadaEn +
                '}';
    }
}
