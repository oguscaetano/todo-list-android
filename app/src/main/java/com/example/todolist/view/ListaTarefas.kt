package com.example.todolist.view

import android.R.color.white
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todolist.ui.theme.Purple40
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.unit.dp
import com.example.todolist.itemLista.ItemTarefa
import com.example.todolist.model.Tarefa

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListaTarefas(
    navController: NavController
) {
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

        val listaTarefas: MutableList<Tarefa> = mutableListOf(
            Tarefa(
                "Jogar futebol",
                "Destruir todo mundo até o talo.",
                1
            ),
            Tarefa(
                "Estudar para a prova",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown.",
                0
            ),
            Tarefa(
                "Comprar repolho",
                "Lorem Ipsum is simply dummy text of the printing and.",
                2
            ),
            Tarefa(
                "Jogo do Curintia",
                "Salve o Corinthians, o campeão dos campeões. Eternamente dentro dos nossos corações.",
                2
            )
        )

        LazyColumn (
            modifier = Modifier.padding(0.dp, 100.dp, 0.dp, 0.dp),
        ) {
            itemsIndexed(listaTarefas){ position, _ ->
                ItemTarefa(position, listaTarefas)
            }
        }

    }
}