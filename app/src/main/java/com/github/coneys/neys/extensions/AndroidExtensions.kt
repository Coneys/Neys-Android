package com.github.coneys.neys.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

val ViewGroup.layoutInflater get() = LayoutInflater.from(context)