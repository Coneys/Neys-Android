package com.github.coneys.neys.shoppingList.listViews

import com.github.coneys.core.optionalCast
import com.github.coneys.shoppinglist.ShoppingListView
import pl.amistad.library.baseEntity.IdentifiableEntity

class ShoppingListRow(val shoppingListView: ShoppingListView) : IdentifiableEntity {
    override fun equalsById(other: IdentifiableEntity): Boolean {
        return shoppingListView.optionalCast<ShoppingListRow>()?.shoppingListView?.id == shoppingListView.id
    }
}