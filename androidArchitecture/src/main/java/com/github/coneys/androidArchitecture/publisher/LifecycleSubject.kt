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

typealias PairMapper<First, Second, Result> = (First, Second) -> Result

abstract class LifecycleSubject<Type>() {

    protected abstract val subject: Subject<BoxedValue<Type>>

    fun <MappedSource> scanMap(
        initialValue: Type,
        source: LifecycleSubject<MappedSource>,
        function: PairMapper<Type, MappedSource, Type>
    ): LifecycleSubject<Type> {

        source.subject
            .scan(BoxedValue(initialValue)) { lastValue: BoxedValue<Type>, boxedValue: BoxedValue<MappedSource> ->
                BoxedValue(function(lastValue.get(), boxedValue.get()))
            }
            .subscribe(subject)

        return this

    }


    fun post(value: Type) {
        subject.onNext(BoxedValue(value))
    }

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

    private fun <T> Observable<BoxedValue<T>>.unbox() = map { it.get() }
    private fun <T> Observable<T>.box() = map { BoxedValue(it) }


}

