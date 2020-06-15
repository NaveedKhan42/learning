package com.naveed.myandroidapp.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.naveed.myandroidapp.R
import com.naveed.myandroidapp.network.Definitions.BASE_IMAGE_URL_W300

/**
 * Extension for the ImageView to load the images from glide
 * @param uri is to provide the remaining url for the Image
 */
fun ImageView.loadImage(uri: String?) {
    val correctedUri = uri ?: "/oSGVmWhn4WT4TI4PCiQrpym6LfW.jpg"

    val options = RequestOptions()
        .error(R.drawable.placeholderimage)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(BASE_IMAGE_URL_W300 + correctedUri)
        .into(this)
}