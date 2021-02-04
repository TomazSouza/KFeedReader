package com.example.kfeedreader.models

import android.net.Uri

data class Item(
    val title: String,
    val author: String,
    val date: Long,
    val link: Uri,
    val image: String
)
