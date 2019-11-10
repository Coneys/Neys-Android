package com.github.coneys.androidArchitecture.publisher

import com.github.coneys.androidArchitecture.boxedValue.BoxedValue
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

class LiveEventSubject<T> : LifecycleSubject<T>() {
    override val subject: Subject<BoxedValue<T>> = PublishSubject.create<BoxedValue<T>>()
}