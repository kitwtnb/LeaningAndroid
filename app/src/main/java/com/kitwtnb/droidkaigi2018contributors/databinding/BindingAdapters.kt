package com.kitwtnb.droidkaigi2018contributors.databinding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun ImageView.loadImage(url: String?) {
    Picasso.get().load(url).into(this)
}
