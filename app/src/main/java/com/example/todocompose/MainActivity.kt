package com.example.todocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todocompose.navigation.SetupNavigation
import com.example.todocompose.ui.theme.ToDoComposeTheme
import com.example.todocompose.ui.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


//we will only have one activity in which case this one. No fragments and multiple composables.
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
// navController variable
    private lateinit var navController: NavHostController
    //initialise viewModel and create instance then pass down
    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoComposeTheme {
                //navController passed to Navigation file
                navController = rememberNavController()
                SetupNavigation(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                    )

                }
            }
        }
    }

