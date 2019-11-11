package com.github.coneys.neys.shoppingList.listViews

import android.view.View
import com.github.coneys.shoppinglist.ShoppingListView
import kotlinx.android.synthetic.main.row_shopping_list_header.view.*
import pl.amistad.library.lists.recyclerView.normal.BaseViewHolder

class ShoppingListViewHolder(itemView: View) : BaseViewHolder<ShoppingListRow>(itemView)
{
    override fun bind(position: Int, entity: ShoppingListRow) {
        itemView.row_shopping_list_header_name.text = entity.shoppingListView.name
    }

}