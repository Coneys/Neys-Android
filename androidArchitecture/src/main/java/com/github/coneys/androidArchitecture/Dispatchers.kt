package com.github.coneys.androidArchitecture

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.ContinuationInterceptor

var IO: ContinuationInterceptor = Dispatchers.IO
var Main: ContinuationInterceptor = Dispatchers.Main
var Default: ContinuationInterceptor = Dispatchers.Default
