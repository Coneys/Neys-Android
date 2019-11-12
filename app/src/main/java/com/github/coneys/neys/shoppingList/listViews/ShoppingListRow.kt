package com.github.coneys.neys.shoppingList.listViews

import com.github.coneys.core.optionalCast
import com.github.coneys.neys.R
import com.github.coneys.shoppinglist.ShoppingListHeader
import pl.amistad.library.baseEntity.IdentifiableEntity

class ShoppingListRow(val shoppingListHeader: ShoppingListHeader) : IdentifiableEntity {
    override fun equalsById(other: IdentifiableEntity): Boolean {
        return shoppingListHeader.optionalCast<ShoppingListRow>()?.shoppingListHeader?.id == shoppingListHeader.id
    }

    val icon = if(shoppingListHeader.isFinished) R.drawable.ic_cart_finished else R.drawable.ic_cart_not_finished
}