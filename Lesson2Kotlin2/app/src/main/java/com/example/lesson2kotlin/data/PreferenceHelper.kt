package com.example.lesson2kotlin.data

import android.content.Context

class PreferenceHelper(context: Context) {

    private val preferenceHelper = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    var userName: String?
        get() = preferenceHelper.getString(USER_NAME_KEY, "")
        set(value) {
            preferenceHelper.edit().putString(USER_NAME_KEY, value).apply()
        }

    companion object {
        const val USER_NAME_KEY = "userName"

    }
}