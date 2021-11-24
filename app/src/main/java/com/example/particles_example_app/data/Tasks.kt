package com.example.particles_example_app.data

import com.example.particles_example_app.data.Task.Family.*


object Tasks: ArrayList<Task>() {

    init {
        add(Task("Test", Default))
    }
}