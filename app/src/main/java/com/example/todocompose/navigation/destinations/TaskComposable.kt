package com.example.todocompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todocompose.util.Action
import com.example.todocompose.util.Constants.LIST_ARGUMENT_KEY
import com.example.todocompose.util.Constants.LIST_SCREEN
import com.example.todocompose.util.Constants.TASK_ARGUMENT_KEY
import com.example.todocompose.util.Constants.TASK_SCREEN

//list composable fun
//each composable contains 1 paramater : lambda
//which is Action for task composable and Integer for list comp
fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
){
    //this is part of nav builder
    //and we find route
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){

    }
}