package com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.COUNTER
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.R
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.showSnackbarMessage
import com.softwaysolutions.dhananjaytrivedi.learnkotlinwithandroid.util.showToastMessage
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        showSnackbarMessage(
            window.decorView.rootView,
            "Second Activity Started"
        )

        val bundle : Bundle? = intent.extras
        val counterValue = bundle!!.getInt(COUNTER)
        counterValueTV.text = counterValue.toString()
        showToastMessage(
            context = applicationContext,
            message = "Last Counter value was $counterValue"
        )

        counterValueTV.setOnClickListener{
            // Share The value using Implicit Intent through various apps

            val message = "Hey! Just wanted to let your know that the counter values is $counterValue"
            val intent = Intent()

            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share With"))
        }

    }
}
