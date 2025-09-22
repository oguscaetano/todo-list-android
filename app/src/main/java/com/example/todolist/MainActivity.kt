package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.ui.theme.ToDoListTheme
import com.example.todolist.view.AddTarefa
import com.example.todolist.view.ListaTarefas

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoListTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "ListaTarefas"
                ) {
                    composable(
                        route = "ListaTarefas"
                    ) {
                        ListaTarefas(navController)
                    }

                    composable(
                        route = "AddTarefa"
                    ) {
                        AddTarefa(navController)
                    }
                }
            }
        }
    }
}