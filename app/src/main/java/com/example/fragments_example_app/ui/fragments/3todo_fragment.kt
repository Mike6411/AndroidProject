package com.example.fragments_example_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments_example_app.R
import com.example.fragments_example_app.data.tasks
import com.example.fragments_example_app.utils.SimpleAdapter

class `3todo_fragment` : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val adapter = SimpleAdapter(
            tasks,
            R.layout.todo_3,
            R.layout.todo_single,
            inflater, container
        ) { itemView, element, i ->

            // Set name
            itemView.findViewById<TextView>(R.id.particleName).text =
                "${element.name} at position $i"
        }

        return adapter.view
    }
}