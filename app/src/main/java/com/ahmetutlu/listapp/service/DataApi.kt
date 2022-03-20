package com.ahmetutlu.listapp.service

import com.ahmetutlu.listapp.model.ListData
import io.reactivex.Single
import retrofit2.http.GET

interface DataApi {
    //https://jsonplaceholder.typicode.com/posts
    //https://picsum.photos/300/300?random=$itemPosition&grayscale`

    @GET("posts")
    fun getList():Single<List<ListData>>//we use Singlefrom Rxjava


}