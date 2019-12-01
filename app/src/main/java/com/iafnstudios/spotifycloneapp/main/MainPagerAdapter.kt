package com.iafnstudios.spotifycloneapp.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.iafnstudios.spotifycloneapp.R
import com.iafnstudios.spotifycloneapp.favorites.FavoritesFragment
import com.iafnstudios.spotifycloneapp.radios.RadiosFragment
import java.lang.IllegalStateException

class MainPagerAdapter(context: Context,fm: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {

    private val tabs = context.applicationContext.resources.getStringArray(R.array.tabs)

    override fun getItem(position: Int): Fragment {
        return when(position){
            TAB_INDEX_RADIOS -> RadiosFragment.newInstance()
            TAB_INDEX_FAVORITES -> FavoritesFragment.newInstance()
            else -> throw IllegalStateException("Can not found.")
        }
    }

    override fun getCount() = 2

    override fun getPageTitle(position: Int): CharSequence? {
        return tabs[position]
    }

    companion object {
        private const val TAB_INDEX_RADIOS = 0
        private const val TAB_INDEX_FAVORITES = 1
    }
}