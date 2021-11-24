package com.example.fragments_example_app.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.fragments_example_app.R
import com.example.fragments_example_app.utils.toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Afegim el layout del main
        setContentView(R.layout.activity_main)

        // Creem l'adapter pel ViewPager i el coloquem on toca
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter

        // Vinculem el ViewPager amb el TabLayout (gestor de pestanyes)
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        // Afegim una acció al botó flotant
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Do you want to know something?", Snackbar.LENGTH_LONG)
                .setAction("YES") {
                    toast("I may be stupid")
                }.show()
        }
    }
}