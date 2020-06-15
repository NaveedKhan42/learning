package com.naveed.myandroidapp.view.adapter

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

/**
 * This bindingAdapter is applied to methods used to manipulate values that are set to views.
 * Its used for custom attributes defined in layout files. It behaves as a static method(similar to extension)
 */
@BindingAdapter("visible")
fun View.visible(visible: Boolean){
    isVisible = visible
}