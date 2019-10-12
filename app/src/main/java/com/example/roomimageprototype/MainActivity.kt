package com.example.roomimageprototype

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomimageprototype.util.Constants
import com.example.roomimageprototype.util.Logger
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ImageDownloader.ImageListener {

    lateinit var imageDownloader: ImageDownloader


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageDownloader = ImageDownloader(this)
        imageDownloader.execute(Constants.IMAGE_URL)
    }

    override fun updateImage(bitmap: Bitmap?) {
        image_view_picture.setImageBitmap(bitmap)
    }

    override fun showProgress(currentProgress: Int?) {

        if(currentProgress != null) {
            progress_bar.progress = currentProgress
        }

        Logger.error(Throwable(currentProgress.toString()))
    }
}
