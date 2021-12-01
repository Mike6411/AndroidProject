package com.example.fragments_example_app.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.fragments_example_app.ui.fragments.`1habits_fragment`
import com.example.fragments_example_app.ui.fragments.`3todo_fragment`
import com.example.fragments_example_app.ui.fragments.`2daily_fragment`
import java.lang.IllegalStateException


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(act: FragmentActivity) :
    FragmentStateAdapter(act) {

    private val TAB_TITLES = arrayOf(
        "HABITS",
        "DAILY",
        "TO DO",
        "CALENDAR"
    )

    // Aquesta funció indica el fragment que s'ha de posar
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> `1habits_fragment`()
            1 -> `2daily_fragment`()
            2 -> `3todo_fragment`()
            3 -> `3todo_fragment`() //aqui ira el calendar_fragment
            else -> throw IllegalStateException("There's only 4 tabs")
        }
    }
//
//    override fun getPageTitle(position: Int): CharSequence {
//        return TAB_TITLES[position]
//    }

    override fun getItemCount(): Int {
        // Show 2 total pages.
        return TAB_TITLES.size
    }

}