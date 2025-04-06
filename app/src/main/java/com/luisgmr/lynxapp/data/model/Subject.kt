package com.luisgmr.lynxapp.data.model

import java.util.UUID

class Subject(
    var name: String,
    val id: String = UUID.randomUUID().toString()
)