package com.github.coneys.shoppinglist.dao

import com.github.coneys.shoppinglist.ShoppingListHeader

interface ShoppingListViewDao {
    suspend fun getAllHeaders(): Collection<ShoppingListHeader>
}