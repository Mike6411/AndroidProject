package com.example.fragments_example_app.data

import com.example.fragments_example_app.data.task.Family.*


object tasks: ArrayList<task>() {

    init {
        add(task("Test", DEFAULT))
    }
}