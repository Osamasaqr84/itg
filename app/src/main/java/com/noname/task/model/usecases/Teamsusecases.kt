package com.noname.task.model.usecases

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.noname.task.datalayer.apidata.ServerGateway
import com.noname.task.datalayer.repositries.*
import com.noname.task.model.entities.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


@SuppressLint("CheckResult")
fun retrieveCharctsData(
    page: Int,
    serverGateway: ServerGateway,
    charactersdata: MutableLiveData<ArrayList<character>>,
    errorLivedat: MutableLiveData<Throwable>,
    loadingLivedat: MutableLiveData<Boolean>
) {
    retrieveCharcts(serverGateway, page).flatMapIterable {
            t -> t.data.results.subList((page-1)*10,page*10)
    }.toList().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {
                Log.d("success1", it.toString())
                charactersdata.postValue(it as ArrayList<character>);
                loadingLivedat.postValue(false)
            },
            {
                Log.d("faild1", it.message)
                errorLivedat.postValue(it);
                loadingLivedat.postValue(false)
            }
        )
}

@SuppressLint("CheckResult")
fun retrieveSearchCharctsResult(
    name: String,
    serverGateway: ServerGateway,
    charctsdata: MutableLiveData<ArrayList<character>>,
    errorLivedat: MutableLiveData<Throwable>,
    loadingLivedat: MutableLiveData<Boolean>
) {
    retrieveSearchCharcts(serverGateway,name).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
            {
                Log.d("success1", it.toString())
                charctsdata.postValue(it.data.results as ArrayList<character>);
                loadingLivedat.postValue(false)
            },
            {
                Log.d("faild1", it.message)
                errorLivedat.postValue(it);
                loadingLivedat.postValue(false)
            }
        )
}


@SuppressLint("CheckResult")
fun retrieveDetails(
    id: Int,
    serverGateway: ServerGateway,
    detailsliveData: MutableLiveData<CharchtDetails>,
    errorLiveData: MutableLiveData<Throwable>,
    loadingLivedata: MutableLiveData<Boolean>
) {
    retrieveCharchtDetail(serverGateway,id)
        .subscribeOn(Schedulers.io())
        ?.observeOn(AndroidSchedulers.mainThread())?.subscribe({ myData ->
            detailsliveData.postValue(myData);
            loadingLivedata.postValue(false)// handle data fetched successfully and API call completed
        }, { throwable ->
            errorLiveData.postValue(throwable);
            loadingLivedata.postValue(false)
        });
}



@SuppressLint("CheckResult")
fun retrieveComics(
    id: Int,
    serverGateway: ServerGateway,
    detailsliveData: MutableLiveData<ArrayList<ComicsResult>>,
    errorLiveData: MutableLiveData<Throwable>,
    loadingLivedata: MutableLiveData<Boolean>
) {
    retrieveComics(serverGateway,id)
        .subscribeOn(Schedulers.io())
        ?.observeOn(AndroidSchedulers.mainThread())?.subscribe({ myData ->
            detailsliveData.postValue(myData.data.results as ArrayList<ComicsResult>);
            loadingLivedata.postValue(false)// handle data fetched successfully and API call completed
        }, { throwable ->
            errorLiveData.postValue(throwable);
            loadingLivedata.postValue(false)
        });
}

@SuppressLint("CheckResult")
fun retrieveSeries(
    id: Int,
    serverGateway: ServerGateway,
    detailsliveData: MutableLiveData<ArrayList<ComicsResult>>,
    errorLiveData: MutableLiveData<Throwable>,
    loadingLivedata: MutableLiveData<Boolean>
) {
    retrieveSeries(serverGateway,id)
        .subscribeOn(Schedulers.io())
        ?.observeOn(AndroidSchedulers.mainThread())?.subscribe({ myData ->
            detailsliveData.postValue(myData.data.results as ArrayList<ComicsResult>);
            loadingLivedata.postValue(false)// handle data fetched successfully and API call completed
        }, { throwable ->
            errorLiveData.postValue(throwable);
            loadingLivedata.postValue(false)
        });
}



@SuppressLint("CheckResult")
fun retrieveStories(
    id: Int,
    serverGateway: ServerGateway,
    detailsliveData: MutableLiveData<ArrayList<ComicsResult>>,
    errorLiveData: MutableLiveData<Throwable>,
    loadingLivedata: MutableLiveData<Boolean>
) {
    retrieveStories(serverGateway,id)
        .subscribeOn(Schedulers.io())
        ?.observeOn(AndroidSchedulers.mainThread())?.subscribe({ myData ->
            detailsliveData.postValue(myData.data.results as ArrayList<ComicsResult>);
            loadingLivedata.postValue(false)// handle data fetched successfully and API call completed
        }, { throwable ->
            errorLiveData.postValue(throwable);
            loadingLivedata.postValue(false)
        });
}

@SuppressLint("CheckResult")
fun retrieveEvents(
    id: Int,
    serverGateway: ServerGateway,
    detailsliveData: MutableLiveData<ArrayList<ComicsResult>>,
    errorLiveData: MutableLiveData<Throwable>,
    loadingLivedata: MutableLiveData<Boolean>
) {
    retrieveEvents(serverGateway,id)
        .subscribeOn(Schedulers.io())
        ?.observeOn(AndroidSchedulers.mainThread())?.subscribe({ myData ->
            detailsliveData.postValue(myData.data.results as ArrayList<ComicsResult>);
            loadingLivedata.postValue(false)// handle data fetched successfully and API call completed
        }, { throwable ->
            errorLiveData.postValue(throwable);
            loadingLivedata.postValue(false)
        });
}