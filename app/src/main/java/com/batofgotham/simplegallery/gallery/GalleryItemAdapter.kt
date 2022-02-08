package com.batofgotham.simplegallery.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.batofgotham.simplegallery.databinding.GalleryImageItemBinding
import com.batofgotham.simplegallery.domain.Photo

class GalleryItemAdapter : ListAdapter<Photo, GalleryItemAdapter.ImageViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(GalleryImageItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Photo>(){
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.url_s == newItem.url_s
        }
    }




    class ImageViewHolder(private val binding : GalleryImageItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo : Photo){
            binding.photo = photo
            binding.executePendingBindings()
        }
    }

}