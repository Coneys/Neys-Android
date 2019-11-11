package com.github.coneys.core

fun <T> Any.cast() = this as T
fun <T> Any.optionalCast() = this as? T