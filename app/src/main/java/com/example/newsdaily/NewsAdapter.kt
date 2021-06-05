package com.example.newsdaily

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(val context: Context,val article: List<Article>):RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_item,parent,false)







        return NewsViewHolder(view)





    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val curr = article[position]
        holder.headline.text=curr.title
        holder.desc.text=curr.description
        Glide.with(context).load(curr.urlToImage).into(holder.img)
        holder.itemView.setOnClickListener {
           // Toast.makeText(context,curr.title,Toast.LENGTH_SHORT).show()
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("URL",curr.url)
            context.startActivity(intent)

        }




    }

    override fun getItemCount(): Int {
        return article.size
    }


}

class NewsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
{
    val headline = itemView.findViewById<TextView>(R.id.title)
    val desc = itemView.findViewById<TextView>(R.id.description)
    val img = itemView.findViewById<ImageView>(R.id.imageView)






}

