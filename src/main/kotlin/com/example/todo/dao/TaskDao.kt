package com.example.todo.dao

import com.example.todo.model.Task
import java.util.*

interface TaskDao {
    fun insertTask(id: UUID, task: Task): Int

    fun insertTask(task: Task): Int {
        val id: UUID = UUID.randomUUID()
        return insertTask(id, task)
    }

    fun selectAllTasks(): List<Task?>?

    fun selectTaskById(id: UUID): Task?

    fun deleteTaskById(id: UUID): Int

    fun updateTaskById(id: UUID, task: Task): Int
}