package com.github.coneys.androidArchitecture

import com.github.coneys.androidArchitecture.publisher.LifecycleSubject
import io.kotlintest.specs.StringSpec
import io.reactivex.observers.TestObserver


abstract class LiveTest() : StringSpec({})
{


    protected fun <T> LifecycleSubject<T>.test(): TestObserver<T> {
        val testObserver = TestObserver<T>()
        subscribe(testObserver)
        return testObserver
    }
}