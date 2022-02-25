package com.conamobile.egzamen.Adapter

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.conamobile.egzamen.ViewFragment1
import com.conamobile.egzamen.ViewFragment2
import com.conamobile.egzamen.ViewFragment3
import com.conamobile.egzamen.ViewFragment4

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {

        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return   when(position){

            0->{
                ViewFragment1()
            }
            1->{
                ViewFragment2()
            }
            2->{
                ViewFragment3()
            }
            3->{
                ViewFragment4()
            }


            else->{
                Fragment()
            }

        }
    }
}
