package com.example.particles_example_app.ui.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.particles_example_app.R
import com.example.particles_example_app.data.Task
import com.example.particles_example_app.utils.toast


/**
 * Adapter que presenta una llista de particules
 */
class fragment_adapter(val context: Context, private val tasks: List<Task>) :
    RecyclerView.Adapter<fragment_adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.habits_single, parent, false)
        // Assignem el layout al ViewHolder
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val particle = tasks[position]

        // Set name
        holder.name.text = particle.name

        // Set color
        // It selects the ID of the color in function of the family of this particle
        val color = when (particle.family) {
            Task.Family.Default -> R.color.quarks
        }
        // It converts the ID to the properly color and set it to the image
        holder.image.setColorFilter(context.getColor(color))

        // Set on item click listener
        holder.view.setOnClickListener {
            // Sabem que es mostrarà "bé" perquè Task és un data class
            context.toast(particle.toString())
        }
    }

    override fun getItemCount(): Int = tasks.size

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.particleName)
        val image: ImageView = view.findViewById(R.id.particleImage)
    }
}