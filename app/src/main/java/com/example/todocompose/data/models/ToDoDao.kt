package com.example.todocompose.data.models

import android.app.appsearch.exceptions.AppSearchException
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
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
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(toDoTask: ToDoTask)

    //updating task
    @Update
    suspend fun updateTask(toDoTask: ToDoTask)

    //deleting specific task
    @Delete
    suspend fun deleteTask(toDoTask: ToDoTask)

    //deleting all tasks
    @Query("DELETE FROM todo_table")
    suspend fun deleteAllTasks()

    //you can search you database based on description or title in database
    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery OR description LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    //Selecting whole database from todoDatabase then sorting it by priority.
    //sorting priority colum where First is L in the word LOW, then
    //M in the priority MEDIUM and THEN H in HIGH. Then finally all other tasks
    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): Flow<List<ToDoTask>>


    //from highest to lowest
    @Query("SELECT * FROM todo_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): Flow<List<ToDoTask>>


}