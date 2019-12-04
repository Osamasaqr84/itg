package com.noname.task.presentation.screens.charactersfragment

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.noname.task.datalayer.apidata.ApiClient
import com.noname.task.datalayer.apidata.ServerGateway

class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    private val apiService: ServerGateway
        get() = ApiClient.getClient().create(ServerGateway::class.java)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass == CharachtersViewModel::class.java) {
            return CharachtersViewModel(apiService) as T
        }

        throw IllegalArgumentException("Invalid view model class type")
    }

}
