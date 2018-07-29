package com.marcosholgado.articlelist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marcosholgado.articlelist.R
import com.marcosholgado.articlelist.model.Article
import com.marcosholgado.core.di.GlideApp
import com.marcosholgado.core.inflate
import com.marcosholgado.core.list_utils.ViewType
import com.marcosholgado.core.list_utils.ViewTypeDelegateAdapter
import kotlinx.android.synthetic.main.item_article.view.*

class NewsDelegateAdapter(val viewActions: onViewSelectedListener?) :
    ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onItemSelected(url: String?)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as Article)
    }

    inner class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.item_article)) {

        private val title = itemView.title
        private val subtitle = itemView.subtitle
        private val category = itemView.category
        private val thumbnail = itemView.thumbnail

        fun bind(item: Article) {
            title.text = item.title
            subtitle.text = item.byline
            category.text = item.section
            GlideApp
                .with(this.itemView)
                .load(item.getThumbnail())
                .into(thumbnail)
        }
    }
}