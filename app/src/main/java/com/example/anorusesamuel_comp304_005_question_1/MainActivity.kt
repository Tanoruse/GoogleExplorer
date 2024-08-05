package com.example.anorusesamuel_comp304_005_question_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up onClickListeners for each button to navigate to the respective activities
        // For this example, let's assume you're navigating to a generic activity for demonstration
        // You'll need to replace "GenericLandmarkActivity::class.java" with actual target activity classes

        findViewById<Button>(R.id.button).setOnClickListener {
            // Example: Navigate to the Church activity
            startActivity(Intent(this, ChurchActivity1::class.java).putExtra("TYPE", "Church"))
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            // Example: Navigate to the Museum activity
            startActivity(Intent(this, MusuemActivity1::class.java).putExtra("TYPE", "Museum"))
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            // Example: Navigate to the Cinemas activity
            startActivity(Intent(this, CinemaActivity1::class.java).putExtra("TYPE", "Cinemas"))
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            // Example: Navigate to the Stadium activity
            startActivity(Intent(this, StadiumActivity1::class.java).putExtra("TYPE", "Stadium"))
        }
    }
}
