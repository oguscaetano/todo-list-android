package com.example.todolist.repository

import com.example.todolist.datasource.DataSource
import com.example.todolist.model.Tarefa
import kotlinx.coroutines.flow.Flow

class TarefasRepository() {

    private val dataSource = DataSource()

    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int) {
        dataSource.salvarTarefa(tarefa, descricao, prioridade)
    }

    fun listarTarefas(): Flow<MutableList<Tarefa>> {
        return dataSource.listarTarefas()
    }
}