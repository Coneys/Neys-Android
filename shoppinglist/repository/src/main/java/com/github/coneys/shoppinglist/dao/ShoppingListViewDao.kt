package com.github.coneys.shoppinglist.dao

import com.github.coneys.shoppinglist.ShoppingListView

interface ShoppingListViewDao {
    suspend fun getAllHeaders(): Collection<ShoppingListView>
}