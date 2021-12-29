package com.example.mavericassignement.other

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImagesWithGlide(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .into(this)
}