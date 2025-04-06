package com.luisgmr.lynxapp.data.repository

import com.luisgmr.lynxapp.data.model.Student

class StudentRepository {
    private val students = mutableListOf<Student>()

    init {
        add(Student("Luis Gustavo Miranda"))
    }

    fun getAll(): List<Student> = students.toList()

    fun getById(id: String): Student? {
        return students.find { it.id == id }
    }

    fun add(student: Student) {
        students.add(student)
    }

    fun update(student: Student) {
        val index = students.indexOfFirst { it.id == student.id }
        if (index != -1) {
            students[index] = student
        }
    }

    fun delete(student: Student) {
        students.remove(student)
    }
}
