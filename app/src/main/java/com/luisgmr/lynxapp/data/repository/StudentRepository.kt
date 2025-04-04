package com.luisgmr.lynxapp.data.repository

import com.luisgmr.lynxapp.data.model.Student

class StudentRepository {
    private val students = mutableListOf<Student>()

    fun getAll() = students.toList()
    fun add(student: Student) = students.add(student)
    fun update(student: Student) { /*...*/ }
    fun delete(student: Student) = students.remove(student)
}