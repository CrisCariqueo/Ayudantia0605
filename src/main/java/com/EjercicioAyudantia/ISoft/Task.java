package com.EjercicioAyudantia.ISoft;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class Task {

    private Long id;
    private String titulo;
    private String prioridad;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaLimite;

    private boolean completada;

    public Task() {}

    public Task(Long id, String titulo, String prioridad, LocalDate fechaLimite) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
        this.completada = false;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public LocalDate getFechaLimite() { return fechaLimite; }
    public void setFechaLimite(LocalDate fechaLimite) { this.fechaLimite = fechaLimite; }

    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }
}