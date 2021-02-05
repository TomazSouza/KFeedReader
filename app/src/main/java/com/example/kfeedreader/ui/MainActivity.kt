package com.example.kfeedreader.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingComponent
import androidx.recyclerview.widget.RecyclerView
import com.example.kfeedreader.R
import com.example.kfeedreader.adapter.FeedsAdapter
import com.example.kfeedreader.adapter.FragmentDataBindingComponent
import com.example.kfeedreader.models.ItemFeed
import com.pkmmte.pkrss.Article
import com.pkmmte.pkrss.Callback
import com.pkmmte.pkrss.PkRSS
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Callback {

    private val listItems = arrayListOf<ItemFeed>()
    private lateinit var rvListFeed: RecyclerView
    private lateinit var feedAdapter: FeedsAdapter

    private var mDataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        feedAdapter = FeedsAdapter(listItems, this, mDataBindingComponent)
        rv_feeds.setHasFixedSize(true)
        rv_feeds.adapter = feedAdapter

        PkRSS.with(this)
            .load("https://rss.tecmundo.com.br/feed")
            .callback(this)
            .async()

    }

    override fun onPreload() {
        Toast.makeText(baseContext, "onPreload", Toast.LENGTH_SHORT).show()
    }

    override fun onLoaded(newArticles: MutableList<Article>?) {
        listItems.clear()
        newArticles?.mapTo(listItems) {
            ItemFeed(it.title, it.author, it.date, it.source, it.enclosure.url)
        }
        feedAdapter.setFeeds(listItems)
    }

    override fun onLoadFailed() {
        Toast.makeText(baseContext, "Failed", Toast.LENGTH_SHORT).show()
    }

}