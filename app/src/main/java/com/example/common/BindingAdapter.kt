package com.example.common

import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("app:errorText")
fun setError(editText: EditText, errorMessage: String?) {

    editText.error = errorMessage

}