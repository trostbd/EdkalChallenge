package com.example.edkalchallenge

import android.app.Application
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(private val context: Application) : AndroidViewModel(context) {

    private val _colorLiveData = MutableLiveData<LedColor>()
    private val _areLightButtonsEnabled = MutableLiveData<Boolean>().apply { value = true }
    val colorLiveData: LiveData<LedColor> = _colorLiveData
    val areLightButtonsEnabled: LiveData<Boolean> = _areLightButtonsEnabled

    fun changeColor(view: View) {
        when (view.id) {
            R.id.btn_get_server ->
                _colorLiveData.value = LedColor.Red(
                    isFlashing = true,
                    colorRes = ContextCompat.getColor(context, R.color.colorRed)
                )

            R.id.btn_no_receipt ->
                _colorLiveData.value = LedColor.Green(
                    duration = 180,
                    colorRes = ContextCompat.getColor(context, R.color.colorGreen)
                )

            R.id.btn_get_receipt ->
                _colorLiveData.value = LedColor.Green(
                    isFlashing = true, duration = 180,
                    colorRes = ContextCompat.getColor(context, R.color.colorGreen)
                )

            R.id.btn_customer_paying ->
                _colorLiveData.value = LedColor.Orange(
                    duration = 120,
                    colorRes = ContextCompat.getColor(context, R.color.colorOrange)
                )
        }
        _areLightButtonsEnabled.value = false
    }

    fun enableButtons() {
        _areLightButtonsEnabled.value = true
    }
}