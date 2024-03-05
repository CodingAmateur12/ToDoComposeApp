package com.example.todocompose.data.models

import androidx.room.Database
import androidx.room.RoomDatabase


//abstract class are like vehicles. for exam[ple. you want to specify that all vehicles should move and have colour.
//You create abstract class vehicle
// Then you create abstract fun move() but dont specify it
// Then you create abstract var colour but dont specify it what exactly it is.
//so you can specify it later

//specify all of your entities or all of your data tables that you have
// in this case we only have one entity or 1 table  ToDoTask
//version of database which is 1 because we just created this databse
//version: This parameter specifies the version number of the database. Whenever you change the schema of your database, such as adding or
// removing tables or columns, you increment this number. It helps Room to handle database migrations properly.
//
@Database(entities = [ToDoTask::class], version =1 , exportSchema = false)
abstract class ToDoDatabase: RoomDatabase()  {

    //returns toDoDao interface
    abstract fun toDoDao(): ToDoDao
}