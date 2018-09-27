package com.marcosholgado.articlelist.adapter

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.marcosholgado.articlelist.Constants
import com.marcosholgado.articlelist.model.Article
import com.marcosholgado.core.list_utils.ViewType
import com.marcosholgado.core.list_utils.ViewTypeDelegateAdapter
import java.util.ArrayList

class ArticleListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = Constants.LOADING
    }

    init {
        delegateAdapters.apply {
            put(Constants.LOADING, LoadingDelegateAdapter())
            put(Constants.NEWS, NewsDelegateAdapter(null))
        }

        items = ArrayList()
        items.add(loadingItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))!!.onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return this.items[position].getViewType()
    }

    fun addArticles(articles: List<Article>) {
        val initPosition = items.lastIndex
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        items.addAll(articles)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

}