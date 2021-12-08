package com.example.fragments_example_app.ui.main

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragments_example_app.R
import kotlinx.android.synthetic.main.dailies_single.view.*

class TemporaryAdapter (
     private val dailies: MutableList<Daily>
     ) : RecyclerView.Adapter<TemporaryAdapter.DailyViewHolder>()
{
    class DailyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {
        return DailyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.dailies_single,
                parent,
                false)
        )
    }

    fun addDaily(daily: Daily){
        dailies.add(daily)
        notifyItemInserted(dailies.size-1)
    }

    fun deleteDaily(){
        dailies.removeAll { daily ->
            daily.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(DailyTitle: TextView, isChecked: Boolean){
        if(isChecked){
            DailyTitle.paintFlags = DailyTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            DailyTitle.paintFlags = DailyTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {
        val curDaily = dailies[position]
        holder.itemView.apply {
            DailyTitle.text = curDaily.title
            Done.isChecked = curDaily.isChecked
            toggleStrikeThrough(DailyTitle, curDaily.isChecked)
            Done.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(DailyTitle, isChecked)
                curDaily.isChecked = !curDaily.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return dailies.size
    }
}