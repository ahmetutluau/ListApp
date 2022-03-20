package com.ahmetutlu.listapp.service

import com.ahmetutlu.listapp.model.ListData
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class DataApiService {
    //https://jsonplaceholder.typicode.com/posts

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(DataApi::class.java)

    fun getDataList():Single<List<ListData>>{
        return api.getList()//we bind our api and service here
    }
}