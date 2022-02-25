package com.conamobile.egzamen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.conamobile.demo_facebook.adapter.FeedAdapter
import com.conamobile.demo_facebook.model.Post
import com.conamobile.demo_facebook.model.Story
import com.conamobile.egzamen.model.Feed
import java.util.ArrayList

class HomeFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }
}