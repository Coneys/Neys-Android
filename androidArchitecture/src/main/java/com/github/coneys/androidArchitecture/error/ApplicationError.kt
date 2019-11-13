package com.github.coneys.androidArchitecture.error

import android.widget.TextView
import androidx.annotation.StringRes
import java.net.UnknownHostException


sealed class ApplicationError {
    data class Exception(val throwable: Throwable) : ApplicationError() {
        val noInternetReason = throwable is UnknownHostException
    }

    data class Message(@StringRes val messageId: Int) : ApplicationError()

}