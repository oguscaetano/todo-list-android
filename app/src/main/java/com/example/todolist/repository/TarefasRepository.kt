package com.example.todolist.repository

import com.example.todolist.datasource.DataSource

class TarefasRepository() {

    private val dataSource = DataSource()

    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int) {
        dataSource.salvarTarefa(tarefa, descricao, prioridade)
    }
}