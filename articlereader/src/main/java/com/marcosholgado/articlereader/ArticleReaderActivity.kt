package com.marcosholgado.articlereader

import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

import com.marcosholgado.articlereader.di.ArticleReaderModule
import com.marcosholgado.articlereader.di.DaggerArticleReaderComponent
import com.marcosholgado.core.di.CoreInjectHelper
import kotlinx.android.synthetic.main.activity_articlereader.*
import javax.inject.Inject


class ArticleReaderActivity : AppCompatActivity(), ArticleReaderContract.View {

    @Inject
    lateinit var presenter: ArticleReaderContract.Presenter

    private val url by lazy {
        intent.getStringExtra("url")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articlereader)
    }


    override fun onResume() {
        super.onResume()

        DaggerArticleReaderComponent
            .builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(applicationContext))
            .articleReaderModule(ArticleReaderModule(this))
            .build()
            .inject(this)

        presenter.loadWebView(url)
    }

    override fun loadWebView(url: String) {
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(request?.url.toString())
                return true
            }
        }
        webView.loadUrl(url)
    }

}
