package com.example.kfeedreader.adapter

import android.app.Activity
import androidx.databinding.DataBindingComponent
import androidx.fragment.app.Fragment

class FragmentDataBindingComponent(fragment: Activity) : DataBindingComponent {
    private val adapter = FragmentBindingAdapters(fragment)

    override fun getFragmentBindingAdapters(): FragmentBindingAdapters {
        return adapter
    }
}