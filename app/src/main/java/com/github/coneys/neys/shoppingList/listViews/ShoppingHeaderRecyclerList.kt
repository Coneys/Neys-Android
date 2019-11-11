package com.github.coneys.neys.shoppingList.listViews

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import pl.amistad.library.lists.recyclerView.normal.ViewHolderManager
import pl.amistad.library.lists.recyclerView.system.DifferentialListAdapter

class ShoppingHeaderRecyclerList(context: Context, attrs: AttributeSet?) :
    RecyclerView(context, attrs)
{
    private lateinit var listAdapter: DifferentialListAdapter<ShoppingListRow>

    fun initialize(
        viewHolderManager: ViewHolderManager<ShoppingListRow>,
        snapHelper: LinearSnapHelper? = null,
        orientation: Int = RecyclerView.VERTICAL
    ) {
        initialize(DifferentialListAdapter(viewHolderManager), snapHelper, orientation)
    }

    fun initialize(
        adapter: DifferentialListAdapter<ShoppingListRow>,
        snapHelper: LinearSnapHelper? = null,
        orientation: Int = RecyclerView.VERTICAL
    ) {
        layoutManager = LinearLayoutManager(context, orientation, false)
        listAdapter = adapter
        this.adapter = listAdapter
        snapHelper?.attachToRecyclerView(this)
    }

    fun submitList(mutableList: MutableList<ShoppingListRow>) {
        listAdapter.submitList(mutableList)
    }

    fun onRowClickedListener(listener: (Pair<ShoppingListRow, Int>) -> Unit) {
        listAdapter.onViewClicked = { _, position, row ->
            listener.invoke(row to position)
        }
    }

}