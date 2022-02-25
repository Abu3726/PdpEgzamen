package com.conamobile.egzamen.memory

import android.content.Context
import androidx.core.content.edit
import java.util.function.DoubleToIntFunction
import java.util.function.LongToDoubleFunction

class MySharedPrefarance(context: Context) {
    private val pref = context.getSharedPreferences("nimadir", Context.MODE_PRIVATE)


        fun isSavedSplash(isSavedSplash: Boolean){
        val editor = pref.edit()
        editor.putBoolean("isSavedSplash", isSavedSplash)
        editor.apply()
    }

    fun getSavedSplash():Boolean{
        return pref.getBoolean("isSavedSplash", false)
    }


}