package com.github.coneys.shoppinglist

import com.github.coneys.core.cast
import com.github.coneys.shoppinglist.events.Event
import com.github.coneys.shoppinglist.useCase.ShoppingListCreateUseCase
import com.github.coneys.shoppinglist.useCase.ShoppingListService
import io.kotlintest.matchers.types.shouldBeInstanceOf
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class ShoppingListUseCaseTest : StringSpec() {
    init {

        "If name is not blank, shopping list should be created"{
            val useCase = getUseCase()

            val event = useCase.create("Test name")

            event.shouldBeInstanceOf<Event.ShoppingListCreated>()
        }

        "If name is blank, shopping list should not be created"{
            val useCase = getUseCase()

            val event = useCase.create(" ")

            event.shouldBeInstanceOf<Event.Failure>()
        }

        "If list is created, name should be same as input"{

            val expectedName = "name"

            val useCase = getUseCase()

            val event = useCase.create(expectedName)

            event.cast<Event.ShoppingListCreated>().shoppingList.name shouldBe expectedName
        }
    }

    private fun getUseCase(): ShoppingListCreateUseCase {
        return ShoppingListService()
    }
}