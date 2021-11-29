package com.example.fragments_example_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments_example_app.R
import com.example.fragments_example_app.data.tasks
import com.example.fragments_example_app.utils.SimpleAdapter
import kotlin.random.Random

class `2daily_fragment` : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val adapter = SimpleAdapter(
            tasks,
            R.layout.dailies_2,
            R.layout.dailies_single,
            inflater, container
        ) { itemView, element, i ->

            // Set name
           // itemView.findViewById<TextView>(R.id.particleName).text =
           //     "${element.name} at position $i"
//
           // // Set random color
           // itemView.findViewById<ImageView>(R.id.particleImage).setColorFilter(Random.nextInt())
        }//

        return adapter.view
    }
}