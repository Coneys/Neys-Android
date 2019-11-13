package com.github.coneys.neys.extensions


import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText


fun View.onClick(listener: () -> Unit) = this.setOnClickListener {
    listener.invoke()
}

val ViewGroup.layoutInflater get() = LayoutInflater.from(context)
