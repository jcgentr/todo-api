package com.example.todo.service

import com.example.todo.dao.TaskDao
import com.example.todo.model.Task
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
class TaskService (@Qualifier("postgres") val taskDao: TaskDao)  {
    fun addTask(task: Task): Int {
        return taskDao.insertTask(task)
    }

    fun getAllTasks(): List<Task?>? {
        return taskDao.selectAllTasks()
    }

    fun getTaskById(id: UUID): Task? {
        return taskDao.selectTaskById(id)
    }

    fun updateTask(id: UUID, updatedTask: Task): Int {
        return taskDao.updateTaskById(id, updatedTask)
    }

    fun deleteTask(id: UUID): Int {
        return taskDao.deleteTaskById(id)
    }
}