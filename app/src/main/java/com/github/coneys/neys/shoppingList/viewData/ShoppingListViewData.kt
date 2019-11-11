package com.github.coneys.neys.shoppingList.viewData

import com.github.coneys.androidArchitecture.ViewResult
import com.github.coneys.androidArchitecture.error.ApplicationError
import com.github.coneys.androidArchitecture.viewData.LoadViewState
import com.github.coneys.neys.shoppingList.listViews.ShoppingListRow
import com.github.coneys.shoppinglist.ShoppingListView


data class ShoppingListViewState(
    val showSuccess: Boolean = false,
    val error: ApplicationError? = null,
    val showLoading: Boolean = false,
    val listViews: Collection<ShoppingListRow> = emptyList()
) :
    LoadViewState(showSuccess, error, showLoading)

sealed class ShoppingListViewResult : ViewResult<ShoppingListViewState> {
    class ShoppingLists(private val lists: Collection<ShoppingListView>) :
        ShoppingListViewResult() {
        override fun toViewState(lastState: ShoppingListViewState): ShoppingListViewState {
            return lastState.copy(
                showSuccess = true,
                error = null,
                showLoading = false,
                listViews = lists.map { ShoppingListRow(it) }
            )
        }
    }

    class Error(val throwable: ApplicationError) : ShoppingListViewResult() {
        override fun toViewState(lastState: ShoppingListViewState): ShoppingListViewState {
            return lastState.copy(
                showSuccess = false,
                error = throwable,
                showLoading = false
            )
        }
    }

    object Loading : ShoppingListViewResult() {
        override fun toViewState(lastState: ShoppingListViewState): ShoppingListViewState {
            return lastState.copy(
                showSuccess = false,
                error = null,
                showLoading = true
            )
        }
    }
}