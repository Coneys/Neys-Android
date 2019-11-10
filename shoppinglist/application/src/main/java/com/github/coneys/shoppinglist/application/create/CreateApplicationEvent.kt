package com.github.coneys.shoppinglist.application.create

import com.github.coneys.shoppinglist.domain.ListId

sealed class CreateApplicationEvent {
    data class ShoppingListCreated(val listId: ListId) : CreateApplicationEvent()
    object CouldNotCreateList : CreateApplicationEvent()
    object CouldNotSaveList : CreateApplicationEvent()
}