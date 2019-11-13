package com.github.coneys.shoppinglist.repository

import com.github.coneys.shoppinglist.ShoppingListHeader
import com.github.coneys.shoppinglist.dao.ShoppingListViewDao
import com.github.coneys.shoppinglist.domain.ShoppingList
import com.github.coneys.shoppinglist.domain.ShoppingListRepository
import java.lang.IllegalArgumentException

class CacheShoppingListRepository(val dao: ShoppingListViewDao) : ShoppingListRepository {

    var wasOnce = false

    override suspend fun save(shoppingList: ShoppingList) {
        if(!wasOnce){
            wasOnce=true
            throw IllegalArgumentException()
        }
        val header = ShoppingListHeader(shoppingList.id, shoppingList.name, false)
        dao.save(header)
    }
}