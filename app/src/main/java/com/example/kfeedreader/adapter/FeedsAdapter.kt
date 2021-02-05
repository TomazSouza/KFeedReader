package com.example.kfeedreader.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kfeedreader.R
import com.example.kfeedreader.databinding.ItemListFeedBinding
import com.example.kfeedreader.models.ItemFeed
import com.facebook.drawee.backends.pipeline.Fresco
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class FeedsAdapter(
    private val listFeeds: ArrayList<ItemFeed>,
    private val context: Context
) : RecyclerView.Adapter<FeedsAdapter.FeedViewHolder>() {

    init {
        Fresco.initialize(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemListFeedBinding = DataBindingUtil
            .inflate(inflater, R.layout.item_list_feed, parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val feeds = listFeeds[position]
        feeds.dateFormatted =
            SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).format(Date(feeds.date))
        holder.binding.feeds = feeds
        holder.binding.btnLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, listFeeds[position].link)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listFeeds.size ?: 0
    }

    fun setFeeds(listItems: java.util.ArrayList<ItemFeed>) {
        this.listFeeds.addAll(listItems)
        notifyDataSetChanged()
    }

    class FeedViewHolder(itemBinding: ItemListFeedBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val binding: ItemListFeedBinding = itemBinding
    }

}