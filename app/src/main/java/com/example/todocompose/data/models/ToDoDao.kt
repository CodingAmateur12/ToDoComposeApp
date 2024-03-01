package com.example.todocompose.data.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
//In DAO you create functions such as update, delete and other.
@Dao
interface ToDoDao {

    //If you wanna learn how to use SQL go to w3schools
    // * means all
    // select all from todo_table and sort by id ascending order

    @Query("SELECT * FROM todo_table ORDER By id ASC")

    //this will read tasks from database
    //Flow is a Coroutine which means it allows to create multiple taks at the same time.
    // it returns list of multiple toDoTasks objects

    fun getAllTasks(): Flow<List<ToDoTask>>

    //when we want specific task with specific is then we can just ask this question to pass it.
    @Query("SELECT * FROM todo_table WHERE id=:taskId")
    //returns a single task
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    //all functions that don't use Flow need to use suspend key
    //adds new task to database
    @Insert
    suspend fun addTask(toDoTask: ToDoTask)
}