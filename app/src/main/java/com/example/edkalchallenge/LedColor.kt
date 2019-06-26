package com.example.edkalchallenge

import android.animation.ValueAnimator

sealed class LedColor {
    abstract val isFlashing: Boolean
    abstract val duration: Int
    abstract val colorRes: Int

    data class Green(override val isFlashing: Boolean = false, override val duration: Int, override val colorRes: Int) : LedColor()
    data class Orange(override val isFlashing: Boolean = false, override val duration: Int, override val colorRes: Int) : LedColor()
    data class Red(override val isFlashing: Boolean = false, override val duration: Int = ValueAnimator.INFINITE, override val colorRes: Int) : LedColor()
}