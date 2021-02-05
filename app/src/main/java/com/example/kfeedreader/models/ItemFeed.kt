package com.example.kfeedreader.models

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView

class ItemFeed(
    val title: String,
    val author: String,
    val date: Long,
    val link: Uri,
    val image: String
) {

    var dateFormatted: String = ""

    @BindingAdapter(value = ["imageUrl"], requireAll = false)
    fun loadImage(imageView: ImageView, image: String?) {
        Glide.with(imageView.context)
            .load(image)
            .into(imageView);
    }


}
