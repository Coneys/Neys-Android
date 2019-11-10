package com.github.coneys.androidArchitecture.viewModel


abstract class ScopedArgumentViewModel<T> : BaseScopedViewModel() {

    fun start(argument: T?) {
        if (!wasStarted) {
            wasStarted = true
            onStart(argument)
        }
    }

    protected abstract fun onStart(argument: T?)
}