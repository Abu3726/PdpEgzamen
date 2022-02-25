package com.conamobile.egzamen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.conamobile.egzamen.Adapter.ViewPagerAdapter
import com.conamobile.egzamen.memory.MySharedPrefarance
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class SplashActivity : AppCompatActivity() {

    lateinit var tab_main: DotsIndicator
    lateinit var tab_layout: TabLayout
    lateinit var view_pager: ViewPager2
    lateinit var textDone: TextView
    lateinit var textSkip: TextView

    override fun onStart() {
        super.onStart()
        if (MySharedPrefarance(this).getSavedSplash()){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        tab_main = findViewById(R.id.tab_main)
        view_pager = findViewById(R.id.view_pager)
        textDone = findViewById(R.id.text_done)
        textSkip = findViewById(R.id.text_skip)
//        tab_layout = findViewById(R.id.tab_layout)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initViews()

    }

    private fun initViews() {

        val viewPager2 = view_pager

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager2.adapter = adapter
        tab_main.setViewPager2(viewPager2)

        //ViewPagerni Swipe true fale
        viewPager2.isUserInputEnabled = true


        textSkip.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            MySharedPrefarance(this).isSavedSplash(true)
            startActivity(intent)
        }

        textDone.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            MySharedPrefarance(this).isSavedSplash(true)
            startActivity(intent)
        }

    }
//    override fun onResume() {
//        super.onResume()
//
//        val tabLayout = tab_layout
//        TabLayoutMediator(tabLayout,view_pager){tab,position ->
//
//            when(position){
//                0->{
//                    Toast.makeText(this, "0", Toast.LENGTH_SHORT).show()
//                }
//                1->{
//                    Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
//                }
//                2->{
//                    Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
//                }
//
//            }
//        }.attach()
//
//    }

}