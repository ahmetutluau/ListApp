package com.ahmetutlu.listapp.vm

import androidx.lifecycle.MutableLiveData
import com.ahmetutlu.listapp.base.BaseVm
import com.ahmetutlu.listapp.model.ListData

class DetailsVM:BaseVm() {
    val incomeData=MutableLiveData<ListData>()
}