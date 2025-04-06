package com.luisgmr.lynxapp.data.repository

import com.luisgmr.lynxapp.data.model.Subject

class SubjectRepository {
    private val subjects = mutableListOf<Subject>()

    init {
        subjects.add(Subject("Desenvolvimento para Dispositivos Móveis"))
        subjects.add(Subject("Interação Humano-Computador"))
        subjects.add(Subject("Projeto de Sistemas"))
    }

    fun getAll(): List<Subject> = subjects.toList()

    fun getById(id: String): Subject? {
        return subjects.find { it.id == id }
    }

    fun add(subject: Subject) {
        subjects.add(subject)
    }

    fun update(subject: Subject) {
        val index = subjects.indexOfFirst { it.id == subject.id }
        if (index != -1) {
            subjects[index] = subject
        }
    }

    fun delete(subject: Subject) {
        subjects.remove(subject)
    }
}
