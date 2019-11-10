package com.github.coneys.shoppinglist

interface ShoppingListRepository {
    fun save(shoppingList: ShoppingList)
}