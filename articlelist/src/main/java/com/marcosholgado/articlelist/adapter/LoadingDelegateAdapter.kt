package com.marcosholgado.articlelist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marcosholgado.articlelist.R
import com.marcosholgado.core.inflate
import com.marcosholgado.core.list_utils.ViewType
import com.marcosholgado.core.list_utils.ViewTypeDelegateAdapter

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) =
        TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {}

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.item_loading)
    )

}