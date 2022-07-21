package com.sanjeet.solulabassignment.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sanjeet.solulabassignment.R

@BindingAdapter("urlToImage")
fun urlToImage(view: ImageView, imageUrl: String?) {

    if (!imageUrl.isNullOrBlank()) {
        Glide.with(view.context).load(imageUrl).apply(
            RequestOptions()
                .placeholder(R.drawable.img_placeholder)
        ).into(view)
    }
}