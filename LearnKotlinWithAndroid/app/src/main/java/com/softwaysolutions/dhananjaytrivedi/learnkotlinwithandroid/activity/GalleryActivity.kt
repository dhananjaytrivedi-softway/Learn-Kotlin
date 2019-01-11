package com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.StaggeredGridLayoutManager
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.adapter.GalleryAdapter
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.R
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.model.UnsplashDataModel
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.repository.Repository
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.images
import kotlinx.android.synthetic.main.activity_gallery.*

class GalleryActivity : AppCompatActivity() {

    // This Activity Displays a recycler view which consists of Images
    // User Click on an Image to open it in Full Screen (WallpaperActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        // Get Sample Data
        val listOfData = getDataFromRepository()

        // Setup Recycler View
        initRecyclerView(listOfData)
    }

    private fun initRecyclerView(listOfData: List<UnsplashDataModel>) {
        // Creating Adapter
        val galleryAdapter = GalleryAdapter(this, listOfData)

        // We are using StaggeredGridLayoutManager to achieve the staggered look instead of a Linear Layout Manager
        val galleryStaggeredLayoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
        galleryRecyclerView.setHasFixedSize(true)
        galleryRecyclerView.layoutManager = galleryStaggeredLayoutManager
        galleryRecyclerView.adapter = galleryAdapter
    }

    private fun getDataFromRepository(): List<UnsplashDataModel> {
        return Repository.listOfImages // Getting Data from HelperClass for now
    }
}
