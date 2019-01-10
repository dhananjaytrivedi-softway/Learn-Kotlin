package com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.activity

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import com.bumptech.glide.Glide
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.R
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.WALLPAPER_URL
import kotlinx.android.synthetic.main.activity_wallpaper.*
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class WallpaperActivity : AppCompatActivity() {

    private val storagePermission = android.Manifest.permission.WRITE_EXTERNAL_STORAGE

    private var wallpaperURL: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaper)

        // Get Image URL Passed in Bundle
        val bundle: Bundle? = intent.extras
        wallpaperURL = bundle!!.getString(WALLPAPER_URL)

        // Load the Image into ImageView from URL
        Glide.with(this).load(wallpaperURL).into(wallpaperIV)

        //
        setWallpaperButton.setOnClickListener {
            verifyPermissions()

            fun saveImage() {
                Glide.with(this).load(wallpaperURL)
                    .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE)) // TODO Load Into, This is Incomplete
            }
        }

    }

    private fun verifyPermissions() {
        val permissionToWriteExternalMemory =
            ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if (permissionToWriteExternalMemory != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(storagePermission), 1)
        }
    }
}
