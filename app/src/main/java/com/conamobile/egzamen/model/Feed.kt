package com.conamobile.egzamen.model

import android.text.InputFilter
import com.conamobile.demo_facebook.model.Post
import com.conamobile.demo_facebook.model.Story
import java.util.ArrayList

class Feed {
    var post: Post? = null
    var stories: ArrayList<Story> = ArrayList<Story>()


    constructor(lengthFilter: InputFilter.LengthFilter){

    }


    constructor(post: Post){
        this.post = post
    }

    constructor(stories: ArrayList<Story>){
        this.stories = stories
    }
}