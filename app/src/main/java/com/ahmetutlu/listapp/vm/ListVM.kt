package com.ahmetutlu.listapp.vm

import androidx.lifecycle.MutableLiveData
import com.ahmetutlu.listapp.base.BaseVm
import com.ahmetutlu.listapp.model.ListData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListVM:BaseVm() {
    val datas=MutableLiveData<List<ListData>>()

    init {
        refreshData()
    }

    fun refreshData(){
        getDataFromEthernet()
    }

    fun getDataFromEthernet(){
        showProgress(true)

        //we use disposable to renew data by Rxjava
        val dis=dataApiService.getDataList()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<List<ListData>>() {
                override fun onSuccess(t: List<ListData>) {
                    datas.postValue(t)
                    showProgress(false)
                }

                override fun onError(e: Throwable) {
                    showMessage("Error")
                    showProgress(false)
                    e.printStackTrace()
                }

            })
        disposables.add(dis)
    }
}