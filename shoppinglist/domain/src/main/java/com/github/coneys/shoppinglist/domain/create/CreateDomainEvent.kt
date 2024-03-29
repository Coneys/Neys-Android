package com.github.coneys.shoppinglist.domain.create

import com.github.coneys.shoppinglist.domain.ShoppingList

sealed class CreateDomainEvent {
    data class ShoppingListCreated(val shoppingList: ShoppingList) : CreateDomainEvent()
    object Failure : CreateDomainEvent()
}