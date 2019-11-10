package com.github.coneys.shoppinglist.domain

import com.github.coneys.core.cast
import com.github.coneys.shoppinglist.domain.create.CreateDomainEvent
import com.github.coneys.shoppinglist.domain.create.CreateListDomainService
import io.kotlintest.matchers.types.shouldBeInstanceOf
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class CreateListDomainTest : StringSpec() {
    init {

        "If name is not blank, shopping list should be created"{
            val useCase = getUseCase()

            val event = useCase.create("Test name")

            event.shouldBeInstanceOf<CreateDomainEvent.ShoppingListCreated>()
        }

        "If name is blank, shopping list should not be created"{
            val useCase = getUseCase()

            val event = useCase.create(" ")

            event.shouldBeInstanceOf<CreateDomainEvent.Failure>()
        }

        "If list is created, name should be same as input"{

            val expectedName = "name"

            val useCase = getUseCase()

            val event = useCase.create(expectedName)

            event.cast<CreateDomainEvent.ShoppingListCreated>().shoppingList.name shouldBe expectedName
        }
    }

    private fun getUseCase(): CreateListDomainService {
        return CreateListDomainService()
    }
}