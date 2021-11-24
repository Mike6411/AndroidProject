package com.example.fragments_example_app.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.fragments_example_app.ui.fragments.`1habits_fragment`
import com.example.fragments_example_app.ui.fragments.`3todo_fragment`
import com.example.fragments_example_app.ui.fragments.`2daily_fragment`
import java.lang.IllegalStateException


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val TAB_TITLES = arrayOf(
        "HABITS",
        "DAILY",
        "TO DO",
        "CALENDAR"
    )

    // Aquesta funció indica el fragment que s'ha de posar
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> `1habits_fragment`()
            1 -> `2daily_fragment`()
            2 -> `3todo_fragment`()
            3 -> `3todo_fragment`() //aqui ira el calendar_fragment
            else -> throw IllegalStateException("There's only 4 tabs")
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return TAB_TITLES[position]
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return TAB_TITLES.size
    }
}