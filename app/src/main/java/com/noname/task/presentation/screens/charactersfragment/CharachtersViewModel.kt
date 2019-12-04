package com.noname.task.presentation.screens.charactersfragment

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.noname.task.datalayer.apidata.ServerGateway
import com.noname.task.model.entities.CharchtDetails
import com.noname.task.model.entities.ComicsResult
import com.noname.task.model.entities.character
import com.noname.task.model.usecases.*

class CharachtersViewModel(apiService: ServerGateway) : ViewModel() {
    val CharachtsData: MutableLiveData<ArrayList<character>> = MutableLiveData()
    val comicsData: MutableLiveData<ArrayList<ComicsResult>> = MutableLiveData()
    val seriesData: MutableLiveData<ArrayList<ComicsResult>> = MutableLiveData()
    val storesData: MutableLiveData<ArrayList<ComicsResult>> = MutableLiveData()
    val eventsData: MutableLiveData<ArrayList<ComicsResult>> = MutableLiveData()
    val errorLivedat: MutableLiveData<Throwable> = MutableLiveData()
    val detailsLivedat: MutableLiveData<CharchtDetails> = MutableLiveData()
    val loadingLivedat: MutableLiveData<Boolean> = MutableLiveData()
    val server:ServerGateway =apiService
    var page = 1
    var loadnow = false

    fun geCharcts()
    {
        loadingLivedat.postValue(true)
        loadnow = true
        retrieveCharctsData(page,server,CharachtsData,errorLivedat,loadingLivedat)
    }

    fun geCharctsResult(name:String)
    {
        loadingLivedat.postValue(true)
        loadnow = true
        retrieveSearchCharctsResult(name,server,CharachtsData,errorLivedat,loadingLivedat)
    }


    fun getCharchterData(id:Int)
    {
        loadingLivedat.postValue(true)
        retrieveDetails(id,server,detailsLivedat,errorLivedat,loadingLivedat)
    }

    fun getComicsData(id:Int)
    {
        loadingLivedat.postValue(true)
        retrieveComics(id,server,comicsData,errorLivedat,loadingLivedat)
    }

    fun getSeriesData(id:Int)
    {
        loadingLivedat.postValue(true)
        retrieveSeries(id,server,seriesData,errorLivedat,loadingLivedat)
    }

    fun getStoresData(id:Int)
    {
        loadingLivedat.postValue(true)
        retrieveSeries(id,server,storesData,errorLivedat,loadingLivedat)
    }


    fun getEventsData(id:Int)
    {
        loadingLivedat.postValue(true)
        retrieveEvents(id,server,eventsData,errorLivedat,loadingLivedat)
    }
}
