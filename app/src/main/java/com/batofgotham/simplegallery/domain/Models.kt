package com.batofgotham.simplegallery.domain

import com.squareup.moshi.Json

data class GalleryResult(
    val photos: PhotoObj,
    @Json(name = "stat")
    val status: String
)

data class PhotoObj(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Long,
    val photo: List<Photo>
)

data class Photo(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String,
    @Json(name = "ispublic")
    val isPublic: Int,
    @Json(name = "isfriend")
    val isFriend: Int,
    @Json(name = "isfamily")
    val isFamily: Int,
    val url_s: String,
    val height_s: Int,
    val width_s: Int
)