package com.example.todo.dao

import com.example.todo.model.Task
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList

@Repository("postgres")
class TaskDataAccessService() : TaskDao {
    //private lateinit val jdbcTemplate: JdbcTemplateAutoConfiguration
    private var DB: ArrayList<Task> = ArrayList()

    override fun insertTask(id: UUID, task: Task): Int {
        DB.add(Task(id, task.description, task.completed))
        return 1
    }

    override fun selectAllTasks(): List<Task?>? {
        return DB
    }

    override fun selectTaskById(id: UUID): Task? {
       return DB.find { it.id == id }
    }

    override fun deleteTaskById(id: UUID): Int {
        val taskMaybe: Task? = selectTaskById(id)
        if (taskMaybe == null) return 0
        DB.remove(taskMaybe)
        return 1
    }

    override fun updateTaskById(id: UUID, task: Task): Int {
        val updatedTaskWithId: Task = Task(id, task.description, task.completed)
        val taskToUpdate = selectTaskById(id)
        val indexOfTaskToUpdate = DB.indexOf(taskToUpdate)
        if (indexOfTaskToUpdate >= 0) {
            DB.set(indexOfTaskToUpdate, updatedTaskWithId)
            return 1
        } else {
            return 0
        }
    }
}