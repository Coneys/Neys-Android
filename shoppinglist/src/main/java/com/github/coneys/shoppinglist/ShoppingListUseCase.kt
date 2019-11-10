package com.github.coneys.shoppinglist

interface ShoppingListUseCase {
    fun create(name: String)
    fun getAll(userToken: UserToken): List<ShoppingList>
}