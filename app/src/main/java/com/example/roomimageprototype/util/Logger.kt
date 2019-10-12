package com.example.roomimageprototype.util

import android.util.Log

 object Logger {
    val ERROR_TAG = "ERROR_TAG"
    fun error(throwable: Throwable){
        Log.e("TAG_ERROR", throwable.toString())
    }
}