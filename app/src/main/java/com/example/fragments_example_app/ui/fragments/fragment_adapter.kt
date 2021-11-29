package com.example.fragments_example_app.ui.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments_example_app.R
import com.example.fragments_example_app.data.task
import com.example.fragments_example_app.utils.toast


/**
 * Adapter que presenta una llista de fragments
 */
class fragment_adapter(val context: Context, private val tasks: List<task>) :
    RecyclerView.Adapter<fragment_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dailies_single, parent, false)
        // Assignem el layout al ViewHolder
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]

        // Set name
        // holder.name.text = task.name

        // Set on item click listener
        holder.view.setOnClickListener {
            // Sabem que es mostrarà "bé" perquè task és un data class
            context.toast(task.toString())
        }
    }

    override fun getItemCount(): Int = tasks.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        //val name: TextView = view.findViewById(R.id.particleName)
        //val image: ImageView = view.findViewById(R.id.particleImage)
    }
}