package com.github.coneys.neys.shoppingList.create

import com.github.coneys.androidArchitecture.error.ApplicationError
import com.github.coneys.androidArchitecture.subject.LiveSubject
import com.github.coneys.androidArchitecture.viewModel.BaseScopedViewModel
import com.github.coneys.neys.R
import com.github.coneys.neys.shoppingList.CreateApplicationEventBus
import com.github.coneys.neys.shoppingList.create.viewData.CreateListViewResult
import com.github.coneys.neys.shoppingList.create.viewData.CreateListViewState
import com.github.coneys.shoppinglist.application.create.CreateApplicationEvent
import com.github.coneys.shoppinglist.application.create.CreateListUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CreateListViewModel(val useCase: CreateListUseCase) : BaseScopedViewModel() {

    private val mutableStateSubject = LiveSubject<CreateListViewState>()
    val statePublisher = mutableStateSubject.asPublisher()

    private val mutableResultSubject = LiveSubject<CreateListViewResult>()

    init {
        mutableStateSubject.scanMap(
            CreateListViewState(),
            mutableResultSubject,
            ::mapResultToState
        )
    }

    private fun mapResultToState(
        lastState: CreateListViewState,
        result: CreateListViewResult
    ): CreateListViewState {
        return result.toViewState(lastState)
    }

    fun create(name: String) {
        launch {
            mutableResultSubject.post(CreateListViewResult.Loading)
            delay(1200)
            val result = when (val appEvent = useCase.create(name)) {
                is CreateApplicationEvent.ShoppingListCreated -> {
                    publishCreateListEvent(appEvent)
                    CreateListViewResult.Success
                }
                CreateApplicationEvent.CouldNotCreateList -> {
                    CreateListViewResult.Error(ApplicationError.Message(R.string.could_not_create_list))
                }
                CreateApplicationEvent.CouldNotSaveList -> {
                    CreateListViewResult.Error(ApplicationError.Message(R.string.could_not_save_list))
                }
            }

            mutableResultSubject.post(result)
        }

    }

    private suspend fun publishCreateListEvent(appEvent: CreateApplicationEvent.ShoppingListCreated) {
        launch { CreateApplicationEventBus.subject.post(appEvent) }
    }

}