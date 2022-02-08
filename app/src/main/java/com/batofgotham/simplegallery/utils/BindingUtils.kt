package com.batofgotham.simplegallery.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.batofgotham.simplegallery.domain.Photo
import com.batofgotham.simplegallery.gallery.GalleryItemAdapter
import com.bumptech.glide.Glide

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, photos : List<Photo>?){
    val adapter = recyclerView.adapter as GalleryItemAdapter
    adapter.submitList(photos)
    adapter.notifyDataSetChanged()
}

@BindingAdapter("image")
fun setImage(imageView: ImageView,imageUrl: String){
    Glide.with(imageView.context).load(imageUrl).centerCrop().into(imageView)
}