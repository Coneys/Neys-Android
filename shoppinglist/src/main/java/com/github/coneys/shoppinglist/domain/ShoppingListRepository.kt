package com.github.coneys.shoppinglist.domain

interface ShoppingListRepository {
     fun save(shoppingList: ShoppingList)
}