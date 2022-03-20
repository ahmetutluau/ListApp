package com.ahmetutlu.listapp.utils

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.ahmetutlu.listapp.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.io.Serializable

//this extension was created for dowload photo from ethernet by glide
fun ImageView.dowloadImage(url:String?, placeHolder: CircularProgressDrawable){
    val options= RequestOptions().placeholder(placeHolder).error(R.mipmap.ic_launcher_round)
    Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)
}
fun makePlaceHolder(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth=6f
        centerRadius=30f
        start()
    }
}
