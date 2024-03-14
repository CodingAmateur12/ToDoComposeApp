package com.example.todocompose.ui.screens.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todocompose.R

@Composable
fun ListScreen(
    //same lambda as in ListComposable
    navigateToTaskScreen: (taskId: Int) -> Unit
){
    Scaffold(
        topBar = {
                 ListAppBar()

        },
        content = {},
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)

        }
    )
}

@Composable
//definig floatingActionButton
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
){
    //whenever we click floating ActionButton we want to pass argument int -1 to task Composable
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
    }) {
        Icon(imageVector = Icons.Filled.Add,
             contentDescription = stringResource(R.string.add_button),
             //tint = Color.DarkGray
             tint = MaterialTheme.colorScheme.primary
        )
        
    }

}


//for the preview its not important to add some value there
//its ujst important to satisfy the parameters which you are calling
@Composable
@Preview
private fun ListScreenPreview() {
    ListScreen(navigateToTaskScreen = {})
}
