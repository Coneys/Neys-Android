package com.github.coneys.androidArchitecture.subject

import com.github.coneys.androidArchitecture.boxedValue.BoxedValue
import com.github.coneys.androidArchitecture.publisher.LifecyclePublisher

abstract class LifecycleSubject<Type> : LifecyclePublisher<Type>() {
    fun post(value: Type) {
        subject.onNext(BoxedValue(value))
    }

    fun asPublisher() = this as LifecyclePublisher<Type>
}