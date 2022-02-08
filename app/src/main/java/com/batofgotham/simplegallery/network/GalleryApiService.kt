package com.batofgotham.simplegallery.network

import com.batofgotham.simplegallery.domain.GalleryResult
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://api.flickr.com/services/rest/"

private val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply{
    level = HttpLoggingInterceptor.Level.BODY
}

private val client : OkHttpClient = OkHttpClient.Builder().apply{
    addInterceptor(interceptor)
}.build()






private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface GalleryApiService{
    @GET("?method=flickr.photos.getRecent&per_page=20&page=1&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
    fun getImages() : Deferred<GalleryResult>
}

object GalleryApi{
    val retrofitService : GalleryApiService by lazy{
        retrofit.create(GalleryApiService::class.java)
    }
}