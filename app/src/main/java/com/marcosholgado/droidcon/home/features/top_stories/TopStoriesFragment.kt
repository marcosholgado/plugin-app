package com.marcosholgado.droidcon.home.features.top_stories

import androidx.navigation.fragment.findNavController
import com.marcosholgado.articlelist.ArticleListFragment
import com.marcosholgado.droidcon.home.features.top_stories.TopStoriesFragmentDirections.action_articles_to_reader

class TopStoriesFragment: ArticleListFragment() {

    override fun onItemSelected(url: String) {
        val navDirections = action_articles_to_reader(url)
        findNavController().navigate(navDirections)
    }
}