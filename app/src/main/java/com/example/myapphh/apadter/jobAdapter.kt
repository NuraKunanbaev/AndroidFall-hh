package com.example.myapphh.adapter

import app.example.myapphh.model.JobModel
import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapphh.JobDetailActivity
import com.example.myapphh.R
import androidx.cardview.widget.CardView

class JobAdapter(private var vacancyList: List<JobModel>) :
    RecyclerView.Adapter<JobAdapter.JobViewHolder>() {

    class JobViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val jobTitle: TextView = itemView.findViewById(R.id.jobTitle)
        val companyName: TextView = itemView.findViewById(R.id.companyName)
        val salary: TextView = itemView.findViewById(R.id.salary)
        val location: TextView = itemView.findViewById(R.id.location)
        val experience: TextView = itemView.findViewById(R.id.experience)
        val publishedData: TextView = itemView.findViewById(R.id.datePublished)
        val companyIcon: ImageView = itemView.findViewById(R.id.companyIcon)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return JobViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JobViewHolder, position: Int) {
        val currentJob = vacancyList[position]
        holder.jobTitle.text = currentJob.title
        holder.companyName.text = currentJob.company
        holder.salary.text = currentJob.salary
        holder.location.text = currentJob.location
        holder.experience.text = currentJob.experience
        holder.publishedData.text = currentJob.publishedData
        holder.companyIcon.setImageResource(currentJob.iconResId)

        holder.cardView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, JobDetailActivity::class.java)

            intent.putExtra("title", currentJob.title)
            intent.putExtra("company", currentJob.company)
            intent.putExtra("salary", currentJob.salary)
            intent.putExtra("location", currentJob.location)
            intent.putExtra("experience", currentJob.experience)
            intent.putExtra("publishedData", currentJob.publishedData)
            intent.putExtra("iconResId", currentJob.iconResId)
            intent.putExtra("description", currentJob.description)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return vacancyList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<JobModel>) {
        vacancyList = newList
        notifyDataSetChanged()
    }
}
