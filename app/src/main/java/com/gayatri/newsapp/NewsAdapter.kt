package com.gayatri.newsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gayatri.newsapp.api.Article
import java.util.ArrayList

class NewsAdapter(private val datalist:ArrayList<Article>): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_card_view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = datalist.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currenItem = datalist[position]
        holder.title.text = currenItem.title;
    }
}


class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var title: TextView = itemView.findViewById(R.id.title)

}

