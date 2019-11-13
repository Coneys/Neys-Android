package com.github.coneys.shoppinglist

import com.github.coneys.core.Component
import com.github.coneys.shoppinglist.dao.CacheShoppingListViewDao
import com.github.coneys.shoppinglist.dao.ShoppingListViewDao
import com.github.coneys.shoppinglist.domain.ShoppingListRepository
import com.github.coneys.shoppinglist.repository.CacheShoppingListRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

object ShoppingListRepositoryComponent : Component {

    private val module = module {
        single { CacheShoppingListViewDao() } bind ShoppingListViewDao::class
        single { CacheShoppingListRepository(get()) } bind ShoppingListRepository::class
    }

    override fun gatherModules(): List<Module> {
        return listOf(module)
    }
}