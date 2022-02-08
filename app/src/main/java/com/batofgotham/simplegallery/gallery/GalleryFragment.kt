package com.batofgotham.simplegallery.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.batofgotham.simplegallery.R
import com.batofgotham.simplegallery.databinding.FragmentGalleryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment : Fragment() {


    private val viewModel: GalleryViewModel by viewModels()
    private lateinit var binding: FragmentGalleryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_gallery,container,false)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val adapter = GalleryItemAdapter()
        binding.imagesRecyclerView.adapter = adapter

        return binding.root
    }


}