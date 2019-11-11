package com.github.coneys.androidArchitecture.subject

import com.github.coneys.androidArchitecture.boxedValue.BoxedValue
import com.github.coneys.androidArchitecture.publisher.LifecyclePublisher
import io.reactivex.subjects.BehaviorSubject

typealias PairMapper<First, Second, Result> = (First, Second) -> Result


class LiveSubject<Type> : LifecycleSubject<Type>() {

    override val subject: BehaviorSubject<BoxedValue<Type>> = BehaviorSubject.create<BoxedValue<Type>>()

    fun setNewCachedValue(newValue: Type) {
        subject.value?.change(newValue)
    }

    fun changeCachedValue(modifyLambda: (Type) -> Type) {
        val currentBoxedValue = subject.value ?: return
        val currentValue = currentBoxedValue.get()

        val newValue = modifyLambda(currentValue)

        currentBoxedValue.change(newValue)

    }

    fun <MappedSource> scanMap(
        initialValue: Type,
        source: LifecyclePublisher<MappedSource>,
        function: PairMapper<Type, MappedSource, Type>
    ): LifecyclePublisher<Type> {

        source.subject
            .scan(BoxedValue(initialValue)) { lastValue: BoxedValue<Type>, boxedValue: BoxedValue<MappedSource> ->
                BoxedValue(function(lastValue.get(), boxedValue.get()))
            }
            .subscribe(subject)

        return this

    }



}
