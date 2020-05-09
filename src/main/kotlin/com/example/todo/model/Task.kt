package com.example.todo.model

import java.util.*
import javax.validation.constraints.NotBlank

data class Task (val id: UUID?, @field:NotBlank val description: String, val completed: Boolean = false)