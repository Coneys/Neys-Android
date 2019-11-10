package com.github.coneys.shoppinglist.events

import com.github.coneys.shoppinglist.ListId

sealed class Event {
    data class ShoppingListCreated(val listId: ListId) : Event()
    object Failure : Event()
}