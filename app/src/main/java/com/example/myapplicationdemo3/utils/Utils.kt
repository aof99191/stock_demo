package com.example.myapplicationdemo3.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


class Utils {
    fun getJson(context: Context, file: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(file).bufferedReader().use{ it.readText() }
        } catch (exception: IOException) {
            exception.printStackTrace()
            return  null
        }
        return  jsonString
    }

    fun getBitmapFromURL(src: String?): Bitmap? {
        try {
            Log.e("src", src!!)
            val url = URL(src)
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input = connection.inputStream
            val myBitmap = BitmapFactory.decodeStream(input)
            Log.e("Bitmap", "returned")
            return myBitmap
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e("Exception", e.message!!)
            return null
        }
    }
}