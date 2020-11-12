package com.madarsoft.madarsoft.ui.second

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.madarsoft.madarsoft.data.model.User
import com.madarsoft.madarsoft.data.prefs.Prefs

class SecondViewModel(private val prefs: Prefs) : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    fun onActivityStarted() {
        getUser()
    }

    private fun getUser() {
        _user.value = prefs.user
    }

}