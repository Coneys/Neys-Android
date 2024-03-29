package com.github.coneys.shoppinglist.domain.create

import com.github.coneys.core.ListId
import com.github.coneys.shoppinglist.domain.ShoppingList


open class CreateListDomainService {
    open fun create(name: String): CreateDomainEvent {

        if (name.isBlank()) return CreateDomainEvent.Failure

        val id = ListId.generate()
        val list = ShoppingList(id, name)

        return CreateDomainEvent.ShoppingListCreated(list)
    }
}