package com.conamobile.egzamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.conamobile.egzamen.Adapter.ViewPagerAdapterMain
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    lateinit var viewPager: ViewPager2
    lateinit var tab_main: TabLayout
    lateinit var image_tab_main: ImageView
    var tabSelected = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.view_pager)
        tab_main = findViewById(R.id.tab_main)

//graph
        tab_main.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tabSelected =tab?.position!!
                when (tab?.position) {
                    0 -> {
                        tab.customView?.findViewById<ImageView>(R.id.image_tab_main)?.setImageResource(R.drawable.home_select)
                    }
                    1 -> {
                        tab.customView?.findViewById<ImageView>(R.id.image_tab_main)?.setImageResource(R.drawable.filter_select)
                    }
                    2 -> {
                        tab.customView?.findViewById<ImageView>(R.id.image_tab_main)?.setImageResource(R.drawable.chat_select)
                    }
                    3 -> {
                        tab.customView?.findViewById<ImageView>(R.id.image_tab_main)?.setImageResource(R.drawable.search_select)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        tab.customView?.findViewById<ImageView>(R.id.image_tab_main)?.setImageResource(R.drawable.home_unselect)
                    }
                    1 -> {
                        tab.customView?.findViewById<ImageView>(R.id.image_tab_main)?.setImageResource(R.drawable.filter_unselect)
                    }
                    2 -> {
                        tab.customView?.findViewById<ImageView>(R.id.image_tab_main)?.setImageResource(R.drawable.chat_unselect)
                    }
                    3 -> {
                        tab.customView?.findViewById<ImageView>(R.id.image_tab_main)?.setImageResource(R.drawable.search_unselect)
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        //end graph

        //adapter start

        val viewPager2 = viewPager

        val adapter= ViewPagerAdapterMain(supportFragmentManager,lifecycle)

        viewPager2.adapter = adapter

        //ViewPagerni Swipe true fale
        viewPager2.isUserInputEnabled = true

        //adapter end

    }

    override fun onResume() {
        super.onResume()
        val tabLayout = tab_main
        TabLayoutMediator(tabLayout,viewPager){tab,position ->

            val inflate =
                LayoutInflater.from(this).inflate(R.layout.item_tab_main, null, false)
            tab.customView = inflate

            when(position){
                0->{
                    inflate.findViewById<ImageView>(R.id.image_tab_main).setImageResource(R.drawable.home_unselect)
                }
                1->{
                    inflate.findViewById<ImageView>(R.id.image_tab_main).setImageResource(R.drawable.filter_unselect)
                }
                2->{
                    inflate.findViewById<ImageView>(R.id.image_tab_main).setImageResource(R.drawable.chat_unselect)
                }
                3->{
                    inflate.findViewById<ImageView>(R.id.image_tab_main).setImageResource(R.drawable.search_unselect)
                }

            }
            if (tabSelected == position){
                inflate.findViewById<ImageView>(R.id.image_tab_main).setImageResource(R.drawable.home_select)
            }
        }.attach()

    }
}