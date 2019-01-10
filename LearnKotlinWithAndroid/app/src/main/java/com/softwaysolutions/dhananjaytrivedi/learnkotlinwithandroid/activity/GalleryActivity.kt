package com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.adapter.GalleryAdapter
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.R
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.images
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val galleryAdapter = GalleryAdapter(
            this,
            images
        )
        val galleryLayoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        galleryRecyclerView.layoutManager = galleryLayoutManager
        galleryRecyclerView.adapter = galleryAdapter

    }
}
