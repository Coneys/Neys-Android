package com.github.coneys.shoppinglist.application

import com.github.coneys.core.Component
import com.github.coneys.shoppinglist.ShoppingListRepositoryComponent
import com.github.coneys.shoppinglist.domain.ShoppingListDomainComponent
import org.koin.core.module.Module
import org.koin.dsl.module

object ShoppingListComponent : Component {

    private val module = module {

    }

    override fun gatherModules(): List<Module> {
        return listOf(module) + ShoppingListDomainComponent.gatherModules() + ShoppingListRepositoryComponent.gatherModules()
    }
}