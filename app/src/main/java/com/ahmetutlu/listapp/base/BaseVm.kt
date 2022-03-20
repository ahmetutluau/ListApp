package com.ahmetutlu.listapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmetutlu.listapp.service.DataApiService
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseVm:ViewModel() {
    var disposables=CompositeDisposable()
    val dataApiService=DataApiService()

    private val _progress=MutableLiveData<Boolean>()//to assign value in VM
    val progress:LiveData<Boolean>//to observe in View
    get() = _progress

    private val _message=MutableLiveData<String>()
    val message:LiveData<String>
    get() = _message

    fun showProgress(value:Boolean){
        _progress.postValue(value)
    }

    fun showMessage(value:String){
        _message.postValue(value)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

}