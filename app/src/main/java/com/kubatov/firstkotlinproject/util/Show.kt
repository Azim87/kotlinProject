package com.kubatov.firstkotlinproject.util

import android.widget.Toast
import com.kubatov.firstkotlinproject.App

 object Show {
    fun me(message: String?) {
        Toast.makeText(App.instance, message, Toast.LENGTH_SHORT).show()
    }
}