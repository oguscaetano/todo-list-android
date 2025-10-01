package com.example.todolist.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todolist.ui.theme.Purple40
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import com.example.todolist.itemLista.ItemTarefa
import com.example.todolist.repository.TarefasRepository

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaTarefas(
    navController: NavController
) {

    val tarefasRepository = TarefasRepository()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Purple40
                )
            )
        },
        containerColor = Color.Black,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("AddTarefa")
                },
                containerColor = Purple40
                ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Ícone de adicionar tarefa.",
                    tint = Color.White
                )
            }
        }
    ) {

        val listaTarefas = tarefasRepository.listarTarefas().collectAsState(mutableListOf()).value

        LazyColumn (
            modifier = Modifier.padding(0.dp, 100.dp, 0.dp, 0.dp),
        ) {
            itemsIndexed(listaTarefas){ position, _ ->
                ItemTarefa(position = position, listaTarefas = listaTarefas)
            }
        }

    }
}