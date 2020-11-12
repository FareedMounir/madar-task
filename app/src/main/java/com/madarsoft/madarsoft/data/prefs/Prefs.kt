package com.madarsoft.madarsoft.data.prefs

import android.content.SharedPreferences
import com.google.gson.Gson
import com.madarsoft.madarsoft.data.model.User

interface Prefs {

    var user: User

}

class PrefsImpl(private val sharedPreferences: SharedPreferences) : Prefs {

    override var user: User
        get() {
            return Gson().fromJson(
                sharedPreferences.getString(USER, "{}"), User::class.java
            )
        }
        set(value) {
            sharedPreferences.edit().putString(USER, Gson().toJson(value)).apply()
        }

    companion object {
        const val USER = "user"
    }

}