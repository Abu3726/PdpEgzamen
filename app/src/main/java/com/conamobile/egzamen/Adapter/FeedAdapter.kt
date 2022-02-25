package com.conamobile.demo_facebook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.conamobile.demo_facebook.model.Story
import com.conamobile.egzamen.R
import com.conamobile.egzamen.model.Feed
import com.google.android.material.imageview.ShapeableImageView
import java.util.ArrayList

class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_HEAD = 0
    private val TYPE_ITEM_STORY = 1

    override fun getItemViewType(position: Int): Int {
        var feed = items[position]

        if (isSecondPos(position)) {
            return TYPE_ITEM_HEAD
        }
        else if (isSecondPos2(position)) {
            return TYPE_ITEM_STORY
        }

        return TYPE_ITEM_STORY




//        if (feed.isHeader) {
//            return TYPE_ITEM_HEAD
//        }
////        if (feed.stories.size > 1) {
////            return TYPE_ITEM_PROFILE_UPDATE
////        }
//        if (feed.stories.size > 0) {
//            return TYPE_ITEM_STORY
//        }
//
//        return TYPE_ITEM_POST
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == 0) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_catagories_view, parent, false)
            return HeadViewHolder(context, view)

        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_catagories_view, parent, false)
        return StoryViewHolder(context, view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]

        if (holder is HeadViewHolder) {

        }

        if (holder is StoryViewHolder) {
//            refreshAdapter(feed.stories, recyclerView)
        }

        if (holder is PostViewHolder) {
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            iv_profile.setImageResource(feed.post!!.profile)
            tv_fullname.text = feed.post!!.fullname

        }
    }

//    fun refreshAdapter(stories: ArrayList<Story>, recyclerView: RecyclerView) {
//        val adapter = StoryAdapter(context, stories)
//        recyclerView.adapter = adapter
//    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun isSecondPos(position: Int): Boolean{
        return position == 0
    }
    fun isSecondPos2(position: Int): Boolean{
        return position == 1
    }

}

class StoryViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {

    init {
        val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}

class PostViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
    var iv_profile: ShapeableImageView
    var tv_fullname: TextView

    init {
        iv_profile = view.findViewById(R.id.iv_background)
        tv_fullname = view.findViewById(R.id.tv_fullname)
    }
}

class HeadViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {

}
