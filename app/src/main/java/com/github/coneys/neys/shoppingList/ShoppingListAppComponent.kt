package com.github.coneys.neys.shoppingList

import com.github.coneys.core.Component
import com.github.coneys.shoppinglist.application.ShoppingListComponent
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object ShoppingListAppComponent : Component {

    private val listModule = module {
        viewModel { ShoppingListIntroViewModel(get()) }
    }

    override fun gatherModules(): List<Module> {
        return ShoppingListComponent.gatherModules() + listModule
    }
}