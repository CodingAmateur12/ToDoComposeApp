package com.example.todocompose.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todocompose.data.models.ToDoTask
import com.example.todocompose.data.repositories.ToDoRepository
import com.example.todocompose.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//view models can be observed by ui components
// and they can react to changes in the data held by viewModel.
//inherits from ViewModel
@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: ToDoRepository
): ViewModel() {
//default value of state of bar is closed by default
    //only when we will trigger search icon then it changes to open
    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    //this will be used to set text in textfield
    val searchTextState: MutableState<String> = mutableStateOf("")

//coroutines flow
    //empty list to satisfy type of the list
    private val _allTasks =
        MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks: StateFlow<List<ToDoTask>> = _allTasks

    //allTasks will be publicly exposed and be observed and get notified
    //when _allTasks changes

    //It will retrieve all tasks that we have in database
    //and it will assign that data to _allTasks
    // its gonna call out repository and its variable getAllTasks which calls toDoDao which calls SQL Query
    fun getAllTasks(){
        viewModelScope.launch{
            repository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }

}