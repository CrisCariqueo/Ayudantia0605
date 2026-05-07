package com.EjercicioAyudantia.ISoft;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
public class Controller {

    private final TaskRepository taskRepository;

    public Controller(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task saved = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getTasks(
            @RequestParam(required = false) String prioridad,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String fechaLimite) {

        List<Task> result = taskRepository.findAll().stream()
                .filter(t -> prioridad == null || t.getPrioridad().equalsIgnoreCase(prioridad))
                .filter(t -> titulo == null || t.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .filter(t -> fechaLimite == null || t.getFechaLimite().equals(LocalDate.parse(fechaLimite)))
                .toList();

        return ResponseEntity.ok(result);
    }
}
