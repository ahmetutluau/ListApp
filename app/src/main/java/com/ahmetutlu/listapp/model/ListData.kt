package com.ahmetutlu.listapp.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Url
import java.io.Serializable
import java.net.URL

data class ListData(
    @SerializedName("userId")
    val userId: Int?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String?,
    @SerializedName("body")
    val body: String?,
    ):Serializable{

}
