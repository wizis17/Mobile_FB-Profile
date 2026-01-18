package com.example.final_project

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.final_project.api.model.UserActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail) // lINK TO XML FILE


        //  Setup the Back Button
        findViewById<ImageView>(R.id.btn_back).setOnClickListener {
            finish()
        }

        // Get data passed from MainActivity
//        val activityData = intent.getSerializableExtra("DATA") as? UserActivity

        // This 'if/else' block handles different Android versions for safety
        val activityData = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            // The modern, type-safe way for Android 13+
            intent.getSerializableExtra("DATA", UserActivity::class.java)
        } else {
            // The older, deprecated way for versions before Android 13
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("DATA") as? UserActivity
        }
        //  Put the data into the UI
        activityData?.let {
            findViewById<TextView>(R.id.detail_title).text = it.title
            findViewById<TextView>(R.id.detail_date).text = it.date
            findViewById<TextView>(R.id.detail_description).text = it.description

            // Load the image using Glide (From URL)
            Glide.with(this)
                .load(it.imageUrl)
                .into(findViewById(R.id.detail_image))
        }
    }
}