package com.example.todocompose.di

import android.content.Context
import androidx.room.Query
import androidx.room.Room
import com.example.todocompose.data.models.ToDoDatabase
import com.example.todocompose.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    //how to provide our room database
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DATABASE_NAME
    ).build()
    //add fun to provide our dao interface

    @Singleton
    @Provides
    fun provideDao(database: ToDoDatabase) = database.toDoDao()

}