package com.example.fragments_example_app.data

import kotlin.random.Random


data class task(
    val name: String,
    val family: Family,
    val somenumber: Double

) {

    // Second constructor with optional parameters
    constructor(name: String, family: Family) : this(
        name,
        family,
        getRandomValue()
    )

    enum class Family {
        DEFAULT
    }

    companion object {
        private fun getRandomValue(): Double = Random.nextInt(0, 999) / 1000.0
    }
}