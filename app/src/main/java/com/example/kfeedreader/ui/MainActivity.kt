package com.example.kfeedreader.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kfeedreader.R
import com.example.kfeedreader.models.Item
import com.pkmmte.pkrss.Article
import com.pkmmte.pkrss.Callback
import com.pkmmte.pkrss.PkRSS

class MainActivity : AppCompatActivity(), Callback {

    private val listItems = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PkRSS.with(this)
            .load("https://rss/tecmundo.com.br/feed")
            .callback(this)
            .async()

    }

    override fun onPreload() {
        Toast.makeText(baseContext, "onPreload", Toast.LENGTH_SHORT).show()
    }

    override fun onLoaded(newArticles: MutableList<Article>?) {
        newArticles?.mapTo(listItems) {
            Item(it.title, it.author, it.date, it.source, it.enclosure.url)
        }
    }

    override fun onLoadFailed() {
        Toast.makeText(baseContext, "Failed", Toast.LENGTH_SHORT).show()
    }

}