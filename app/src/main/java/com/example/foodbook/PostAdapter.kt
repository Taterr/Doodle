package com.example.foodbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapter(private val context: Context, private val Posts: List<Post>)
    : RecyclerView.Adapter<PostAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.post_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myPost = Posts[position]
        Glide.with(context)
            .load(myPost.imageUrl)
            .placeholder((R.drawable.logo))
            .error(R.drawable.ic_showpassword)
            .into(holder.imageView)

        holder.captionText.text = myPost.caption
        holder.usernameText.text = myPost.location
    }

    override fun getItemCount(): Int {
        return Posts.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val imageView: ImageView = itemView.findViewById(R.id.imageViewPost)
        val captionText: TextView = itemView.findViewById(R.id.textViewCaption)
        val usernameText: TextView = itemView.findViewById(R.id.textViewUsername)
    }
}