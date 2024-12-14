package com.example.myapplication.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class FlowersAdapter(
    val context: Context,
    val imageList: List<ImageItem>
) : RecyclerView.Adapter<FlowersAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val titleView: TextView = itemView.findViewById(R.id.imageTitle)
        val descriptionView: TextView = itemView.findViewById(R.id.imageDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_task, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageItem = imageList[position]
        holder.imageView.setImageResource(imageItem.imageResId)
        holder.titleView.text = imageItem.title
        holder.descriptionView.text = imageItem.description
    }

    override fun getItemCount(): Int = imageList.size
}