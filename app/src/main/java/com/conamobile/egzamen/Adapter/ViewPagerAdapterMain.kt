package com.conamobile.egzamen.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.conamobile.egzamen.CollectionsFragment
import com.conamobile.egzamen.HomeFragment
import com.conamobile.egzamen.MessageFragment
import com.conamobile.egzamen.SearchFragment

class ViewPagerAdapterMain(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {

        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> {
                HomeFragment()
            }
            1 -> {
                CollectionsFragment()
            }
            2 -> {
                MessageFragment()
            }
            3 -> {
                SearchFragment()
            }

            else -> {
                Fragment()
            }

        }
    }
}
