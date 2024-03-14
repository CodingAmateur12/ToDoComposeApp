package com.example.todocompose.navigation

import androidx.navigation.NavHostController
import com.example.todocompose.util.Action
import com.example.todocompose.util.Constants.LIST_SCREEN

//navController is a parameter here
//you need to add nav controller dependancy
//action name of this lambda
// list variable will take this Action which we are going to pass from composable
//and we are going to use this action to navigate to our list composable
//and this action will be passed as an argument.
//Unit means basically nothing to return, void

//wto values (Action, Int) and they use these two values to navigate to different screens.
class Screens(navController: NavHostController) {
    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            //popup to a given destination
            // inclusive to remove task Composable from backstack and just leave List Screen
            popUpTo(LIST_SCREEN) { inclusive = true}
        }
    }
    //we dont wanna pass whole object so only pass id
    //navigate to task composable #
    //taskId as an argument
    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}