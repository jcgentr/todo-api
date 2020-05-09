package com.example.todo.api

import com.example.todo.model.Task
import com.example.todo.service.TaskService
import org.springframework.lang.NonNull
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RequestMapping("api/v1/task")
@RestController
class TaskController(val taskService: TaskService) {
    @GetMapping("/test")
    fun getTask(): Task = Task(UUID.randomUUID(), "Continue developing this API", false)

    @PostMapping
    fun addTask(@Valid @NonNull @RequestBody task: Task): Int = taskService.addTask(task)

    @GetMapping
    fun getAllTasks(): List<Task?>? = taskService.getAllTasks()

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: UUID): Task? = taskService.getTaskById(id)

    @PutMapping("/{id}")
    fun updateTaskById(@PathVariable id: UUID,
                       @Valid @NonNull @RequestBody updatedTask: Task): Int {
        println(updatedTask.toString())
        return taskService.updateTask(id, updatedTask)
    }

    @DeleteMapping("/{id}")
    fun deleteTaskById(@PathVariable id: UUID): Int = taskService.deleteTask(id)
}