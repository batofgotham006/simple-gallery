package com.batofgotham.simplegallery.utils

import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.batofgotham.simplegallery.domain.Photo
import com.batofgotham.simplegallery.gallery.GalleryItemAdapter
import com.bumptech.glide.Glide

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, photos : List<Photo>?){
    val adapter = recyclerView.adapter as GalleryItemAdapter
    Log.i("DA",photos.toString())
    adapter.submitList(photos)
    adapter.notifyDataSetChanged()
}

@BindingAdapter("image")
fun setImage(imageView: ImageView,imageUrl: String){
//    val imageUri = imageUrl.toUri().buildUpon().build()
    Glide.with(imageView.context).load(imageUrl).centerCrop().into(imageView)
}