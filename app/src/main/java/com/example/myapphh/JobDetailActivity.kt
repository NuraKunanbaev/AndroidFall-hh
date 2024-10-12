package com.example.myapphh

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.ImageButton

class JobDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)

        val backButton: ImageButton = findViewById(R.id.backButton)
        val jobTitle: TextView = findViewById(R.id.jobTitleDetail)
        val companyName: TextView = findViewById(R.id.companyNameDetail)
        val salary: TextView = findViewById(R.id.salaryDetail)
        val location: TextView = findViewById(R.id.locationDetail)
        val experience: TextView = findViewById(R.id.experienceDetail)
        val publishedData: TextView = findViewById(R.id.datePublishedDetail)
        val companyIcon: ImageView = findViewById(R.id.companyIconDetail)


        val title = intent.getStringExtra("title")
        val company = intent.getStringExtra("company")
        val salaryText = intent.getStringExtra("salary")
        val locationText = intent.getStringExtra("location")
        val experienceText = intent.getStringExtra("experience")
        val publishedDataText = intent.getStringExtra("publishedData")
        val iconResId = intent.getIntExtra("iconResId", 0)


        jobTitle.text = title
        companyName.text = company
        salary.text = salaryText
        location.text = locationText
        experience.text = experienceText
        publishedData.text = publishedDataText
        companyIcon.setImageResource(iconResId)

        backButton.setOnClickListener {
            finish()
        }
    }
}
