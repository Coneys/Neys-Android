package com.github.coneys.shoppinglist.domain

interface ShoppingListRepository {
     suspend fun save(shoppingList: ShoppingList)
}