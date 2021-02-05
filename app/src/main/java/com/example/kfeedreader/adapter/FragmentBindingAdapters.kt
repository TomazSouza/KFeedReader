package com.example.kfeedreader.adapter

import android.app.Activity
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class FragmentBindingAdapters constructor(val fragment: Activity) {
    @BindingAdapter(value = ["imageUrl"], requireAll = false)
    fun loadImage(imageView: ImageView, image: String?) {
        Glide.with(fragment)
            .load(image)
            .into(imageView);
    }
}