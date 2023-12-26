package com.example.lesson7kotlin

import androidx.annotation.DrawableRes

data class SneakersModel(
    @DrawableRes val image: Int,
    val someText: String
)