package com.luisgmr.lynxapp.data.model

import java.util.UUID

class Student(
    var name: String,
    var subjects: MutableList<Subject> = mutableListOf(),
    val id: String = UUID.randomUUID().toString()
)