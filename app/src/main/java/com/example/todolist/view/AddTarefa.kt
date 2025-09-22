package com.example.todolist.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.componentes.CaixaDeTexto
import com.example.todolist.model.Tarefa
import com.example.todolist.ui.theme.Purple40
import com.example.todolist.ui.theme.RB_Green
import com.example.todolist.ui.theme.RB_Red
import com.example.todolist.ui.theme.RB_Yellow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTarefa(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Adicionar tarefa",
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
//        containerColor = Color.Black
    ) {

        var tituloTarefa by remember {
            mutableStateOf("")
        }

        var descricaoTarefa by remember {
            mutableStateOf("")
        }

        // estados radio buttons
        var prioridade by remember {
            mutableStateOf("baixa")
        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Titulo
            CaixaDeTexto(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 120.dp, 20.dp, 0.dp),
                tituloTarefa,
                {
                    tituloTarefa = it
                },
                "Título da tarefa",
                1,
                KeyboardType.Text
            )

            // Descricao
            CaixaDeTexto(
                Modifier
                    .fillMaxWidth().height(200.dp)
                    .padding(20.dp, 20.dp, 20.dp, 10.dp),
                descricaoTarefa,
                {
                    descricaoTarefa = it
                },
                "Descrição",
                5,
                KeyboardType.Text
            )

            // Prioridades
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Prioridade:")
                RadioButton(
                    selected = prioridade == "baixa",
                    onClick = {
                        prioridade = "baixa"
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RB_Green
                    )
                )

                RadioButton(
                    selected = prioridade == "media",
                    onClick = {
                        prioridade = "media"
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RB_Yellow
                    )
                )

                RadioButton(
                    selected = prioridade == "alta",
                    onClick = {
                        prioridade = "alta"
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RB_Red
                    )
                )
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(Purple40),
                onClick = {}
            ) {
                Text("Adicionar")
            }
        }
    }
}

@Preview
@Composable
private fun AddTarefaPreview() {
    AddTarefa(navController = rememberNavController())
}