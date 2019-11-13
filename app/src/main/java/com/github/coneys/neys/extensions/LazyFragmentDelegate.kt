package com.github.coneys.neys.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class LazyFragmentDelegate<T>(val producer: () -> T) : ReadOnlyProperty<Fragment, T> {

    private var cachedValue: T? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val result = if (cachedValue != null) {
            cachedValue!!
        } else {
            thisRef.viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                fun onDestroy() {
                    cachedValue = null
                }
            })

            cachedValue = producer()
            cachedValue!!
        }

        return result
    }
}

fun <T> lazyFragment(producer: () -> T) = LazyFragmentDelegate(producer)
