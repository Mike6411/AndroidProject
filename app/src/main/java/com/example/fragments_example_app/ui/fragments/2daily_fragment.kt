package com.example.fragments_example_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments_example_app.R
import com.example.fragments_example_app.data.tasks

class `2daily_fragment` : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dailies_2, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            context?.let {
                // Només utilitzo el context si no és null; sino, finalitzo activity
                view.adapter = fragment_adapter(it, tasks)
            } ?: activity?.finish()
        }

        return view
    }
}