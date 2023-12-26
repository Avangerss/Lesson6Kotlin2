package com.example.lesson1kotlin2.fragments

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import java.io.Serializable

data class Cryptocurrency(
    val image: String,
    val text: String
): Serializable