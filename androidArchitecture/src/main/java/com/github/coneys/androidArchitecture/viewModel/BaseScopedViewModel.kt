package com.github.coneys.androidArchitecture.viewModel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModel
import com.github.coneys.androidArchitecture.Main
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseScopedViewModel : ViewModel(), CoroutineScope, LifecycleOwner {

    internal var wasStarted = false
    private val job = Job()
    private val lifeRegistry = LifecycleRegistry(this)

    override val coroutineContext: CoroutineContext = job + Main
    override fun getLifecycle() = lifeRegistry

    init {
        lifeRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        lifeRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    override fun onCleared() {
        job.cancel()
        lifeRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        super.onCleared()
    }
}
