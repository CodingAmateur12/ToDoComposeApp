package com.example.todocompose.ui.screens.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.todocompose.R
import com.example.todocompose.components.PriorityItem
import com.example.todocompose.data.models.Priority
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.todocompose.ui.theme.LARGE_PADDING


//this app will have 2 app bars. Default and search one
@Composable
fun ListAppBar(){
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
){

    TopAppBar(
        title = {
            Text (text = stringResource(R.string.tasks))
        },
        actions = {
            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
                )

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorScheme.primaryContainer,
            titleContentColor = colorScheme.primary,
        )
        )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
){
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked )
}
@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
){
    IconButton(
        onClick = {onSearchClicked() }
    ){
        Icon(imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.searchtasks),
            tint = colorScheme.secondary
        )
    }
}
//add drawable vector image to drawables
//then put its id in painter
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
) { //we hold here state and by default its not expanded
    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(
        onClick = { expanded = true}
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = stringResource(R.string.sort_tasks),
            tint = colorScheme.secondary
        ) //painter is used for xml files

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            //set your Priority composable in text field
            DropdownMenuItem(
                text = { PriorityItem(priority = Priority.LOW) },
                onClick = { expanded = false
                    onSortClicked(Priority.LOW)
                }
            )
            DropdownMenuItem(
                text = { PriorityItem(priority = Priority.HIGH) },
                onClick = { expanded = false
                    onSortClicked(Priority.HIGH)
                }
            )
            DropdownMenuItem(
                text = { PriorityItem(priority = Priority.NONE) },
                onClick = { expanded = false
                    onSortClicked(Priority.NONE)
                }
            )
        }

    }
}
@Composable
fun DeleteAllAction(
    onDeleteClicked: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = stringResource(id = R.string.delete_all_action),
            tint = MaterialTheme.colorScheme.primary
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDeleteClicked()
                },
                text = {
                    Text(
                        modifier = Modifier
                            .padding(start = LARGE_PADDING),
                        text = stringResource(id = R.string.delete_all_action),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            )
        }
    }
}



@Composable
@Preview
private fun DefaultListAppBarPreview(){
    DefaultListAppBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}