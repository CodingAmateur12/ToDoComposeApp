package com.example.todocompose.ui.screens.list

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todocompose.R
import com.example.todocompose.ui.viewmodels.SharedViewModel
import com.example.todocompose.util.SearchAppBarState

@Composable
fun ListScreen(
    //same lambda as in ListComposable
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
){
    //observing searchAppBarState from viewModel, cause composable can observe it lol
    //then we can pass this variable to ListAppBar
    //then from out ListScreen we are observing this value whenever it changes
    //it will recompose out ListAppBar with a new value below
    val searchAppBarState: SearchAppBarState
            by sharedViewModel.searchAppBarState
    val searchTextState: String
            by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
                 ListAppBar(
                     sharedViewModel = sharedViewModel,
                     searchAppBarState = searchAppBarState,
                     searchTextState = searchTextState
                 )

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
//@Composable
//@Preview
//private fun ListScreenPreview() {
//    ListScreen(navigateToTaskScreen = {})
//}

