package com.github.coneys.shoppinglist.dao

import com.github.coneys.shoppinglist.ShoppingListView
import com.github.coneys.shoppinglist.domain.ListId

internal class CacheShoppingListViewDao : ShoppingListViewDao {


    private val map: HashMap<ListId, ShoppingListView> = HashMap()

    init {
        addInitialValues()
    }

    private fun addInitialValues() {
        ShoppingListView(ListId.generate(), "Tesco").add()
        ShoppingListView(ListId.generate(), "Alkohol").add()
    }

    private fun ShoppingListView.add() {
        map[id] = this
    }

    override suspend fun getAll(): Collection<ShoppingListView> {
        return map.values
    }
}