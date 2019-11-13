package com.github.coneys.shoppinglist.domain

import com.github.coneys.core.Component
import com.github.coneys.shoppinglist.domain.create.CreateListDomainService
import org.koin.core.module.Module
import org.koin.dsl.module

object ShoppingListDomainComponent : Component {

    private val module = module {
        single { CreateListDomainService() }
    }

    override fun gatherModules(): List<Module> {
        return listOf(module)
    }
}