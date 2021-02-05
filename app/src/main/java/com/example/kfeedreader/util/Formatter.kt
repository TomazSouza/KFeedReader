package com.example.kfeedreader.util

import java.text.SimpleDateFormat
import java.util.*

object Formatter {

    fun date(text: Long): String {
        return SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).format(Date(text))
    }

}