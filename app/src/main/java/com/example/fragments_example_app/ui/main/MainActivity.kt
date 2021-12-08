package com.example.fragments_example_app.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.fragments_example_app.R
import com.example.fragments_example_app.utils.toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.dailies.*


class MainActivity : AppCompatActivity() {

    private lateinit var temporaryAdapter: TemporaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Afegim el layout del main
        setContentView(R.layout.activity_main)
        temporaryAdapter = TemporaryAdapter(mutableListOf())

        //Aquest es l'adapter temporari
        rvDailiesList.adapter = temporaryAdapter
        rvDailiesList.layoutManager = LinearLayoutManager(this)

        AddDaily.setOnClickListener{
            val dailyTitle = etDailyTitle.text.toString()
            if(dailyTitle.isNotEmpty()) {
                val daily = Daily(dailyTitle)
                temporaryAdapter.addDaily(daily)
                etDailyTitle.text.clear()
            }
        }
        DeleteCompleted.setOnClickListener{
            temporaryAdapter.deleteDaily()
        }

        // Aquest es l'adapter bo
        //val sectionsPagerAdapter = SectionsPagerAdapter(this)
        //val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        //viewPager.adapter = sectionsPagerAdapter

//        viewPager.currentItem

//        Vinculem el ViewPager amb el TabLayout (gestor de pestanyes)
//        val tabs: TabLayout = findViewById(R.id.tabs)
//        tabs.setupWithViewPager(viewPager)

        // Afegim una acció al botó flotant
        // Enrecordat de tornarlo a fer gran per la proxima entrega
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Do you want to know something?", Snackbar.LENGTH_LONG)
                .setAction("YES") {
                    toast("I may be stupid")
                }.show()
        }
    }
}