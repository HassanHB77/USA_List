package com.hassan.android.usastate

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hassan.android.usastate.data.Repository
import com.hassan.android.usastate.model.Object

class ListViewModel : ViewModel(){

    var listOfPeopleLiveData: MutableLiveData<List<Object>> = MutableLiveData()

    fun loadPeople(activity: Activity){
        listOfPeopleLiveData.value = Repository.getPeople(activity)
    }

}