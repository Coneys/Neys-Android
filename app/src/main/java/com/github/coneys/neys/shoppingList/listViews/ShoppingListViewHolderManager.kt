package com.github.coneys.neys.shoppingList.listViews

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.coneys.neys.R
import pl.amistad.library.lists.recyclerView.normal.BaseViewHolder
import pl.amistad.library.lists.recyclerView.normal.ViewHolderManager

class ShoppingListViewHolderManager : ViewHolderManager<ShoppingListRow>() {
    override fun createViewHolder(
        viewType: Int,
        parent: ViewGroup,
        inflater: LayoutInflater
    ): BaseViewHolder<out ShoppingListRow> {

        val view = inflater.inflate(R.layout.row_shopping_list_header, parent, false)

        return ShoppingListViewHolder(view)
    }

    override fun getType(item: ShoppingListRow, position: Int): Int {
        return 0
    }
}