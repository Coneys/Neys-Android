package com.github.coneys.androidArchitecture

interface ViewResult<T> {
    fun toViewState(lastState: T): T
}