package com.github.coneys.core

import org.koin.core.module.Module

interface Component {
    fun gatherModules(): List<Module>
}