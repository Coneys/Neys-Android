package com.github.coneys.neys.shoppingList

import com.github.coneys.androidArchitecture.subject.LiveSubject
import com.github.coneys.androidArchitecture.viewModel.BaseScopedViewModel
import com.github.coneys.neys.shoppingList.viewData.ShoppingListViewResult
import com.github.coneys.neys.shoppingList.viewData.ShoppingListViewState
import com.github.coneys.shoppinglist.dao.ShoppingListViewDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ShoppingListIntroViewModel(private val dao: ShoppingListViewDao) : BaseScopedViewModel() {

    private val mutableStateSubject = LiveSubject<ShoppingListViewState>()
    val statePublisher = mutableStateSubject.asPublisher()

    private val mutableResultSubject = LiveSubject<ShoppingListViewResult>()

    init {
        mutableStateSubject.scanMap(
            ShoppingListViewState(),
            mutableResultSubject,
            ::mapResultToState
        )
    }

    private fun mapResultToState(
        lastState: ShoppingListViewState,
        result: ShoppingListViewResult
    ): ShoppingListViewState {
        return result.toViewState(lastState)
    }

    fun loadInitial() {
        executeOnce("loadInitial"){
            launch {
                mutableResultSubject.post(ShoppingListViewResult.Loading)
                delay(1000)
                val headers = dao.getAllHeaders()
                mutableResultSubject.post(ShoppingListViewResult.ShoppingLists(headers))
            }
        }
    }

    fun reloadHeaders(){
        launch {
            val headers = dao.getAllHeaders()
            mutableResultSubject.post(ShoppingListViewResult.ShoppingLists(headers))
        }

    }

}