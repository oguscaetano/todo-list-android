package com.example.todolist.datasource

import com.example.todolist.model.Tarefa
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource() {

    private val db = FirebaseFirestore.getInstance()

    fun salvarTarefa(tarefa: String, descricao: String, prioridade: Int) {

        val tarefaMap = hashMapOf(
            "tarefa" to tarefa,
            "descricao" to descricao,
            "prioridade" to prioridade
        )

        db.collection("tarefas").document(tarefa).set(tarefaMap)
            .addOnCompleteListener { }
            .addOnFailureListener { }
    }

    private val _todasTarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())
    private val todasTarefas: StateFlow<MutableList<Tarefa>> = _todasTarefas


    fun listarTarefas(): Flow<MutableList<Tarefa>> {

        val listaTarefas: MutableList<Tarefa> = mutableListOf()

        db.collection("tarefas").orderBy("prioridade", Query.Direction.DESCENDING).get().addOnCompleteListener { querySnapshot ->
            if (querySnapshot.isSuccessful) {
                for (document in querySnapshot.result) {
                    val tarefa = document.toObject(Tarefa::class.java)
                    listaTarefas.add(tarefa)
                    _todasTarefas.value = listaTarefas
                }
            }
        }
        return todasTarefas
    }

}