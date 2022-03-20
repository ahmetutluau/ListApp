package com.ahmetutlu.listapp.utils.extensions

import androidx.fragment.app.Fragment

fun Fragment.showMessage(message:String){
    requireContext().showMessage(message)
}