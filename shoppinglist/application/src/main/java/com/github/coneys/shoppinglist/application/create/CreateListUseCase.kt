package com.github.coneys.shoppinglist.application.create

import com.github.coneys.shoppinglist.domain.ShoppingList
import com.github.coneys.shoppinglist.domain.ShoppingListRepository
import com.github.coneys.shoppinglist.domain.create.CreateDomainEvent
import com.github.coneys.shoppinglist.domain.create.CreateListDomainService

interface CreateListUseCase {
    fun create(name: String): CreateApplicationEvent
}

internal class CreateListApplicationService(
    val domainService: CreateListDomainService,
    val repository: ShoppingListRepository
) :
    CreateListUseCase {

    override fun create(name: String): CreateApplicationEvent {

        return when (val creationResult = domainService.create(name)) {
            is CreateDomainEvent.ShoppingListCreated -> saveList(creationResult.shoppingList)
            CreateDomainEvent.Failure -> CreateApplicationEvent.CouldNotCreateList
        }


    }

    private fun saveList(shoppingList: ShoppingList): CreateApplicationEvent {
        return try {
            repository.save(shoppingList)
            CreateApplicationEvent.ShoppingListCreated(shoppingList.id)
        } catch (e: Exception) {
            CreateApplicationEvent.CouldNotSaveList
        }
    }
}