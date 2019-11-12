package com.github.coneys.neys.shoppingList.listViews

import android.view.View
import kotlinx.android.synthetic.main.row_shopping_list_header.view.*
import pl.amistad.library.lists.recyclerView.normal.BaseViewHolder

class ShoppingListViewHolder(itemView: View) : BaseViewHolder<ShoppingListRow>(itemView)
{
    override fun bind(position: Int, entity: ShoppingListRow) {
        val header = entity.shoppingListHeader
        itemView.row_shopping_list_header_name.text = header.name
        itemView.row_shopping_list_header_active.setImageResource(entity.icon)

    }

}