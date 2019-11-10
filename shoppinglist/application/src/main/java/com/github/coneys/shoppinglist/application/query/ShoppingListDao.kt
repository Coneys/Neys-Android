package com.github.coneys.shoppinglist.application.query

interface ShoppingListDao {
    suspend fun getAll(): List<ShoppingListView>
}