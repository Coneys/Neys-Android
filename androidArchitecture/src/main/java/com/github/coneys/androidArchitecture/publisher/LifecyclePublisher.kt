package com.github.coneys.androidArchitecture.publisher

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.github.coneys.androidArchitecture.boxedValue.BoxedValue
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.Subject

abstract class LifecyclePublisher<Type> {
    internal abstract val subject: Subject<BoxedValue<Type>>


    fun observe(lifecycleOwner: LifecycleOwner, observer: (Type) -> Unit) {

        val subscribe = subject
            .unbox()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)

        val lifecycleObserver = object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                subscribe.dispose()
            }
        }
        lifecycleOwner.lifecycle.addObserver(lifecycleObserver)
    }

    fun subscribe(subscriber: Observer<Type>) = subject.unbox().subscribe(subscriber)

    protected fun <T> Observable<BoxedValue<T>>.unbox() = map { it.get() }
    protected fun <T> Observable<T>.box() = map { BoxedValue(it) }

}