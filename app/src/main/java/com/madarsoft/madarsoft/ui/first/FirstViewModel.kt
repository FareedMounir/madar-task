package com.madarsoft.madarsoft.ui.first

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.madarsoft.madarsoft.data.model.User
import com.madarsoft.madarsoft.data.prefs.Prefs
import com.madarsoft.madarsoft.utils.SingleLiveEvent

class FirstViewModel(private val prefs: Prefs) : ViewModel() {

    private val _openSecond = SingleLiveEvent<Boolean>()
    val openSecond: LiveData<Boolean>
        get() = _openSecond

    private val _submitButtonEnabled = MutableLiveData<Boolean>()
    val submitButtonEnabled: LiveData<Boolean>
        get() = _submitButtonEnabled

    private val _ageError = SingleLiveEvent<Boolean>()
    val ageError: LiveData<Boolean>
        get() = _ageError

    private var username = ""
    private var age = 0
    private var jobTitle = ""
    private var gender = "Male"

    fun setUsername(username: String) {
        this.username = username
        checkInput()
    }

    fun setAge(age: String) {
        if (age.isEmpty()) {
            this.age = 0
        } else {
            this.age = age.toInt()
        }
        checkInput()
    }

    fun setJobTitle(jobTitle: String) {
        this.jobTitle = jobTitle
        checkInput()
    }

    fun setGender(gender: String) {
        this.gender = gender
    }

    private fun checkInput() {
        _submitButtonEnabled.value = !(username.isEmpty() || age == 0 || jobTitle.isEmpty())
    }

    fun onSubmitButtonClicked() {
        if (isAgeValid()) {
            submit()
        }
    }

    private fun isAgeValid(): Boolean {
        return if (age in 1..99) {
            true
        } else {
            _ageError.value = true
            false
        }
    }

    private fun submit() {
        val user = User(username, age, jobTitle, gender)
        prefs.user = user

        _openSecond.value = true
    }

}