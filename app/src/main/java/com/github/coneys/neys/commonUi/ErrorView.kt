package com.github.coneys.neys.commonUi

import android.content.Context
import android.util.AttributeSet
import com.github.coneys.neys.R
import com.github.coneys.neys.extensions.layoutInflater
import com.google.android.material.card.MaterialCardView

class ErrorView(context: Context?, attrs: AttributeSet?) : MaterialCardView(context, attrs) {
    init {
        layoutInflater.inflate(R.layout.view_error, this, true)
    }

    fun render(iconRes: Int, messageRes: Int) {

    }
}