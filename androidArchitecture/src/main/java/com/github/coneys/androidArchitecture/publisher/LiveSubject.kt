package com.github.coneys.androidArchitecture.publisher

import com.github.coneys.androidArchitecture.boxedValue.BoxedValue
import io.reactivex.subjects.BehaviorSubject

class LiveSubject<T> : LifecycleSubject<T>() {

    override val subject: BehaviorSubject<BoxedValue<T>> = BehaviorSubject.create<BoxedValue<T>>()

    fun setNewCachedValue(newValue: T) {
        subject.value?.change(newValue)
    }

    fun changeCachedValue(modifyLambda: (T) -> T) {
        val currentBoxedValue = subject.value ?: return
        val currentValue = currentBoxedValue.get()

        val newValue = modifyLambda(currentValue)

        currentBoxedValue.change(newValue)

    }
}
