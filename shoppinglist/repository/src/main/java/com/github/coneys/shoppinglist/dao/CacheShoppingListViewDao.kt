package com.github.coneys.shoppinglist.dao

import com.github.coneys.core.ListId
import com.github.coneys.shoppinglist.ShoppingListHeader

internal class CacheShoppingListViewDao : ShoppingListViewDao {



    private val map: HashMap<ListId, ShoppingListHeader> = HashMap()

    init {
        addInitialValues()
    }

    private fun addInitialValues() {
        ShoppingListHeader(ListId.generate(), "Tesco",  false).add()
        ShoppingListHeader(ListId.generate(), "Castorama", true).add()
    }

    override suspend fun save(header: ShoppingListHeader) {
        header.add()
    }

    private fun ShoppingListHeader.add() {
        map[id] = this
    }

    override suspend fun getAllHeaders(): Collection<ShoppingListHeader> {
        return map.values
    }
}