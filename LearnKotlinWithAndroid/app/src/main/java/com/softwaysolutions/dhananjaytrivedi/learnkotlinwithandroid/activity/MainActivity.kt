package com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.COUNTER
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.R
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.showSnackbarMessage
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickMeButton.setOnClickListener {
            updateTextCounter()
            showSnackbarMessage(
                view = it.rootView,
                message = "You clicked the button"
            )
        }

        clickCounterTV.setOnClickListener {
            startActivity(Intent(this, GalleryActivity::class.java))
        }
    }

    private fun updateTextCounter() {
        clickCounterTV.text = (++counter).toString()

        if (counter > 5) {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(COUNTER, counter)
            startActivity(intent)
        }
    }
}
