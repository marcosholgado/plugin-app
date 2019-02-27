package com.marcosholgado.sample.home.features.top_stories

import androidx.navigation.fragment.findNavController
import com.marcosholgado.articlelist.ArticleListFragment
import com.marcosholgado.sample.home.features.top_stories.TopStoriesFragmentDirections.Companion.actionArticlesToReader

class TopStoriesFragment: ArticleListFragment() {

    override fun onItemSelected(url: String) {
        val navDirections = actionArticlesToReader(url)
        findNavController().navigate(navDirections)
    }
}