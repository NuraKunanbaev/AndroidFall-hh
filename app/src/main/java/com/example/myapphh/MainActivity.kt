package com.example.myapphh

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.example.myapphh.model.JobModel
import com.example.myapphh.adapter.JobAdapter
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {

    private lateinit var jobAdapter: JobAdapter
    private lateinit var vacancyList: List<JobModel>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        vacancyList = listOf(
            JobModel(
                "Android-разработчик",
                "70 000$",
                "Otbasy bank",
                "Almaty",
                "from 3 to 6 years",
                "published yesterday",
                R.drawable.otbasybank,
                "qwed"
            ),
            JobModel(
                "iOS-разработчик",
                "30 000$",
                "Kaspi bank",
                "Almaty",
                "no experience",
                "published 3 days ago",
                R.drawable.kaspi,
                "jisjf"
            ),
            JobModel(
                "Веб-разработчик",
                "60 000$",
                "Yandex",
                "Moscow",
                "6 years",
                "published today",
                R.drawable.yandex,
                "sjdfhd"
            )
        )

        jobAdapter = JobAdapter(vacancyList)
        recyclerView.adapter = jobAdapter

        val editText: EditText = findViewById(R.id.editText)
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterJobs(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })


        val filterButton: ImageButton = findViewById(R.id.filterButton)
        filterButton.setOnClickListener {
            val query = editText.text.toString()
            filterJobs(query)
        }
    }

    private fun filterJobs(query: String) {
        val filteredList = vacancyList.filter { job ->
            job.title.contains(query, ignoreCase = true) ||
                    job.company.contains(query, ignoreCase = true)
        }
        jobAdapter.updateList(filteredList)
    }
}




