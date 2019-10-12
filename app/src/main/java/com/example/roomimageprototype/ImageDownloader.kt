package com.example.roomimageprototype

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import com.example.roomimageprototype.util.Logger
import java.net.URL

class ImageDownloader(val imageListener: ImageListener): AsyncTask<String?, Int, Bitmap?>(){
    interface ImageListener{
        fun updateImage(bitmap: Bitmap?)
        fun showProgress(currentProgress: Int?)
    }

    override fun doInBackground(vararg url: String?): Bitmap? {
        val url = URL(url[0])
        val urlConnection = url.openConnection()
        var urlStream = urlConnection.getInputStream()


        var bitmap: Bitmap? = null
        var fileSize = urlConnection.contentLength
        var count: Int = 0
        var data = ByteArray(1024)
        var total: Long = 0

//        while({count = urlStream.read(data); count}() > 0){
//            total += count
//            publishProgress((total * 100/fileSize).toInt())
//        }


        try{
             bitmap = BitmapFactory.decodeStream(urlStream)
        } catch (throwable: Throwable){
            Logger.error(throwable)
        }

        return bitmap
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        imageListener.showProgress(values[0])
    }

   override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
        Logger.error(Throwable("onPostExecite"))
        imageListener.updateImage(result)
    }
}