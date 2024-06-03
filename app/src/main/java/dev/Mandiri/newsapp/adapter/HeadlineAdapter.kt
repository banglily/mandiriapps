package dev.Mandiri.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.Mandiri.newsapp.R
import dev.Mandiri.newsapp.data.Article

class HeadlineAdapter(val context: Context): RecyclerView.Adapter<HeadlineAdapter.ArticleViewHolder>(){

    var articles: ArrayList<Article> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.single_headline,parent,false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article:Article = articles[position]
        holder.title.text = article.title

        if(article.author != null){
            holder.author.text = article.author.toString()
        }else{
            holder.author.text = "UnKnown"
        }

        Glide.with(context)
            .load(article.urlToImage)
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return articles.size
    }


    class ArticleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView = itemView.findViewById<ImageView>(R.id.imageView_singleHeadline)
        var title = itemView.findViewById<TextView>(R.id.title_singleHeadline)
        val author = itemView.findViewById<TextView>(R.id.author_singleHeadline)
        val date = itemView.findViewById<TextView>(R.id.date_singleHeadline)
    }

    fun clear() {
        articles.clear()
        notifyDataSetChanged()
    }

    fun addAll(art: List<Article>) {
        articles.addAll(art)
        notifyDataSetChanged()
    }

}