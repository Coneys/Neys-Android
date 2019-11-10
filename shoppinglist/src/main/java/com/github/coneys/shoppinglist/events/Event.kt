package com.github.coneys.shoppinglist.events

import com.github.coneys.shoppinglist.ShoppingList

internal sealed class Event {
    data class ShoppingListCreated(val shoppingList: ShoppingList) : Event()
    object Failure : Event()
}