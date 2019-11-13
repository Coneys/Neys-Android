package com.github.coneys.neys.extensions

import android.widget.TextView
import com.github.coneys.androidArchitecture.error.ApplicationError
import com.github.coneys.neys.R

fun ApplicationError.showOnTextView(textView: TextView) {
    when (this) {
        is ApplicationError.Exception -> {
            if (noInternetReason) textView.setText(R.string.internet_connection_lost)
            else textView.setText(R.string.unknown_error)
        }
        is ApplicationError.Message -> textView.setText(this.messageId)
    }
}