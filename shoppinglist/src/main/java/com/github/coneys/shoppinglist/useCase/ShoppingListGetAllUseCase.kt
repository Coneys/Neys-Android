package com.github.coneys.shoppinglist.useCase

import com.github.coneys.shoppinglist.ShoppingList

interface ShoppingListGetAllUseCase {
    fun getAll(): List<ShoppingList>
}