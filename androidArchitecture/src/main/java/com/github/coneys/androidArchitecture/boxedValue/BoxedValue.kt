package com.github.coneys.androidArchitecture.boxedValue


class BoxedValue<T>(private var value: T) {
    fun get(): T {
        return value
    }

    fun change(newValue: T) {
        value = newValue
    }
}