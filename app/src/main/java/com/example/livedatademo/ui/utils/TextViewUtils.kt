package com.example.livedatademo.ui.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

inline fun TextView.textChanges(crossinline changed: (CharSequence) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            changed.invoke(s)
        }

        override fun afterTextChanged(s: Editable?) {
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
    })
}