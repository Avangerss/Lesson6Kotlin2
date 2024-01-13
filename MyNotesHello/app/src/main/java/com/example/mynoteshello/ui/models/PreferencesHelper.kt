package com.example.mynoteshello.ui.models

import android.content.Context

class PreferencesHelper(context: Context) {

        val preferenceHelper = context.getSharedPreferences("Back", Context.MODE_PRIVATE)
        var isShovOnBoard: Boolean
            get() {
                return preferenceHelper.getBoolean("KEY", false)
            }
            set(value) {
                preferenceHelper.edit().putBoolean("KEY", value).apply()
            }
    }