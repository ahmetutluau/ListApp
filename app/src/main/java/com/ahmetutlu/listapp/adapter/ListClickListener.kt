package com.ahmetutlu.listapp.adapter

import android.view.View
import com.ahmetutlu.listapp.model.ListData

interface ListClickListener {
    fun imageClick(view: View,model:ListData)
}