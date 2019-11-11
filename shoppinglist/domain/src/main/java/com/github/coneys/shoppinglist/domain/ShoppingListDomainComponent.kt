package com.github.coneys.shoppinglist.domain

import com.github.coneys.core.Component
import org.koin.core.module.Module
import org.koin.dsl.module

object ShoppingListDomainComponent : Component {

    private val module = module {

    }

    override fun gatherModules(): List<Module> {
        return listOf(module)
    }
}