package com.luisgmr.lynxapp.data.model

class Student(
    val name: String,
    val subjects: MutableList<Subject> = mutableListOf()
) {
}