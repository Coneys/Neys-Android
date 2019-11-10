package com.github.coneys.shoppinglist.useCase

import com.github.coneys.shoppinglist.ListId
import com.github.coneys.shoppinglist.events.Event

interface ShoppingListCreateUseCase {
    suspend fun create(name: String): Event
}

internal class ShoppingListService : ShoppingListCreateUseCase {
    override suspend fun create(name: String): Event {

        if(name.isBlank()) return Event.Failure

        val id = ListId.generate()
        return Event.ShoppingListCreated(id)
    }
}