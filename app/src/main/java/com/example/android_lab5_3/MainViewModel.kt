package com.example.android_lab5_3

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import java.net.URL
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
    val bitmapData = MutableLiveData<Bitmap>()

    fun downloadImageTask() {
        viewModelScope.launch(Dispatchers.IO) {
            val newurl = URL("https://hurrytolove.ru/wp-content/uploads/2018/12/18245676.jpg")
            val mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream())
            withContext(Dispatchers.Main) {
                bitmapData.value = mIcon_val
            }
        }
    }
}