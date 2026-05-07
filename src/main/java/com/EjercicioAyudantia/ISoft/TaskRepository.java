package com.EjercicioAyudantia.ISoft;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {

    private final List<Task> tasks = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public Task save(Task task) {
        task.setId(counter.getAndIncrement());
        tasks.add(task);
        return task;
    }

    public List<Task> findAll() {
        return tasks;
    }
}