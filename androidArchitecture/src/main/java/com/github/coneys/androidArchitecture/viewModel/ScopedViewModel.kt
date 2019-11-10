package com.github.coneys.androidArchitecture.viewModel


abstract class ScopedViewModel : BaseScopedViewModel() {

    fun start() {
        if (!wasStarted) {
            wasStarted = true
            onStart()
        }
    }

    protected abstract fun onStart()
}