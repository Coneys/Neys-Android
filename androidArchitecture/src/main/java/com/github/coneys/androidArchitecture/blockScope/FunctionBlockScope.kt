package com.github.coneys.androidArchitecture.blockScope

open class FunctionBlockScope {

    private val list = ArrayList<String>()

    @Synchronized
    fun executeOnce(tag: String, lambda: () -> Unit) {
        if (!list.contains(tag)) {
            executeFunction(lambda, tag)
        } else
            skipFunction(tag)
    }

    protected open fun skipFunction(tag: String) = Unit

    protected open fun executeFunction(lambda: () -> Unit, tag: String) {
        lambda.invoke()
        list.add(tag)
    }
}
