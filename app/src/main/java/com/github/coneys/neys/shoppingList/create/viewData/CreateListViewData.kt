package com.github.coneys.neys.shoppingList.create.viewData

import com.github.coneys.androidArchitecture.ViewResult
import com.github.coneys.androidArchitecture.error.ApplicationError
import com.github.coneys.androidArchitecture.viewData.LoadViewState

data class CreateListViewState(
    val error: ApplicationError? = null,
    val showLoading: Boolean = false
)

sealed class CreateListViewResult : ViewResult<CreateListViewState> {

    class Error(val throwable: ApplicationError) : CreateListViewResult() {
        override fun toViewState(lastState: CreateListViewState): CreateListViewState {
            return lastState.copy(
                error = throwable,
                showLoading = false
            )
        }
    }

    object Loading : CreateListViewResult() {
        override fun toViewState(lastState: CreateListViewState): CreateListViewState {
            return lastState.copy(
                error = null,
                showLoading = true
            )
        }
    }

    object Success : CreateListViewResult() {
        override fun toViewState(lastState: CreateListViewState): CreateListViewState {
            return lastState.copy(
                error = null,
                showLoading = false
            )
        }
    }
}