package com.github.coneys.shoppinglist

import com.github.coneys.core.Component
import org.koin.core.module.Module
import org.koin.dsl.module

object ShoppingListComponent : Component {

    private val module = module {

    }

    override fun gatherModules(): List<Module> {
        return listOf(module)
    }
}