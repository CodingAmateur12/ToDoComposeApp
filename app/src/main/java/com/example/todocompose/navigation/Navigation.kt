package com.example.todocompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.todocompose.navigation.destinations.listComposable
import com.example.todocompose.navigation.destinations.taskComposable
import com.example.todocompose.util.Constants.LIST_SCREEN

//navigation function
@Composable
fun SetupNavigation(
    //we are using this navController to remember our screens
    //which we are defined in our Screens class
    navController: NavHostController
){
    //value that will keep track of our composables
    val screen = remember(navController) {
        Screens(navController = navController)
    }
    //calling NavHost inside which we are calling navigation graph
    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        //two screens list and task composables
        listComposable(
            navigateToTaskScreen = screen.task
        )
        taskComposable (
            navigateToListScreen = screen.list
        )
    }
}