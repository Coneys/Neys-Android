package com.github.coneys.androidArchitecture.subject

import com.github.coneys.androidArchitecture.boxedValue.BoxedValue
import com.github.coneys.androidArchitecture.publisher.LifecyclePublisher
import io.reactivex.subjects.PublishSubject

class LiveEventSubject<Type> : LifecycleSubject<Type>() {
    override val subject: PublishSubject<BoxedValue<Type>> =
        PublishSubject.create<BoxedValue<Type>>()


}