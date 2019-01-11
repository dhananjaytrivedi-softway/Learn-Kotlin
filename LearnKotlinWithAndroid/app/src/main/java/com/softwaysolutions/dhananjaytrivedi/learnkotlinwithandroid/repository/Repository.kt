package com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.repository

import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.model.UnsplashDataModel
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.images

class Repository {

    // This class is responsible for providing data to the Model
    // Currently it's just returning Sample Data from HelperClass

    companion object {
        val listOfImages: List<UnsplashDataModel> = getDataFromSource()

        private fun getDataFromSource(): List<UnsplashDataModel> {
            return images
        }
    }
}