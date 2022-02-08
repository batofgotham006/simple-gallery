package com.batofgotham.simplegallery.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.batofgotham.simplegallery.domain.Photo
import com.batofgotham.simplegallery.network.GalleryApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GalleryViewModel @Inject constructor(): ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getImages()
    }


    private val _photos = MutableLiveData<List<Photo>>()
    val photos : LiveData<List<Photo>>
        get() = _photos


    private fun getImages(){
        coroutineScope.launch{
            var getImagesDeferred = GalleryApi.retrofitService.getImages()
            try{
                _photos.value = getImagesDeferred.await().photos.photo
            }catch (t:Throwable){
            }
        }
    }
}