package com.github.coneys.neys.extensions


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun View.onClick(listener: () -> Unit) = this.setOnClickListener {
    listener.invoke()
}

val ViewGroup.layoutInflater get() = LayoutInflater.from(context)