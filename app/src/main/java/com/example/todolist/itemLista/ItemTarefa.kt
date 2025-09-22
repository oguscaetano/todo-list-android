package com.example.todolist.itemLista

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.model.Tarefa
import com.example.todolist.ui.theme.RB_Green
import com.example.todolist.ui.theme.RB_Red
import com.example.todolist.ui.theme.RB_Yellow
import com.example.todolist.ui.theme.White

@Composable
fun ItemTarefa(
    position: Int,
    listaTarefas: MutableList<Tarefa>
) {

    val tituloTarefa = listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].prioridade

    val nivelPrioridade: String = when(prioridade){
        0 -> "Baixa"
        1 -> "Média"
        2 -> "Alta"
        else -> "Baixa"
    }

    val corPrioridade = when(prioridade){
        0 -> RB_Green
        1 -> RB_Yellow
        2 -> RB_Red
        else -> RB_Green
    }

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp, 10.dp),
        colors = CardDefaults.cardColors(White),
    ) {
        Column (

        ) {
            // titulo da tarefa
            Text(
                tituloTarefa,
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Bold
            )

            // descricao da tarefa
            Text(
                descricaoTarefa,
                modifier = Modifier.padding(20.dp)
            )


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                // texto prioridade
                Text(
                    "Prioridade:",
                    modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp)
                )

                // cor prioridade
                Card(
                    colors = CardDefaults.cardColors(corPrioridade)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(8.dp, 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            nivelPrioridade,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                IconButton(
                    onClick = {},
                    modifier = Modifier.padding(100.dp, 0.dp, 0.dp, 0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Ícone de apagar tarefa.",
                        tint = Color.Red,
                    )
                }
            }
        }
    }
}

//@Preview
//@Composable
//private fun ItemTarefaPreview() {
//    ItemTarefa()
//}