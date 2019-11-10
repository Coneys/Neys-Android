package com.github.coneys.shoppinglist.application

import com.github.coneys.shoppinglist.application.create.CreateApplicationEvent
import com.github.coneys.shoppinglist.domain.ListId
import com.github.coneys.shoppinglist.domain.ShoppingList
import com.github.coneys.shoppinglist.domain.ShoppingListRepository
import com.github.coneys.shoppinglist.domain.create.CreateDomainEvent
import com.github.coneys.shoppinglist.domain.create.CreateListDomainService
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doThrow
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.kotlintest.matchers.types.shouldBeInstanceOf
import io.kotlintest.specs.StringSpec

class CreateListApplicationTest : StringSpec() {
    init {

        "When list created successfully, and list saved in repository, should return success"{

            val useCase: CreateListUseCase = getUseCase(successDomainService(), successRepository())

            useCase.create("test").shouldBeInstanceOf<CreateApplicationEvent.ShoppingListCreated>()

        }

        "When list create failed, should return CouldNotCreateList event"{

            val useCase: CreateListUseCase = getUseCase(failureDomainService(), successRepository())

            useCase.create("test").shouldBeInstanceOf<CreateApplicationEvent.CouldNotCreateList>()

        }

        "When list created successfully, but saving failed, should return CouldNotSaveList event"{

            val useCase: CreateListUseCase = getUseCase(successDomainService(), failureRepository())

            useCase.create("test").shouldBeInstanceOf<CreateApplicationEvent.CouldNotSaveList>()

        }

    }

    private fun successRepository(): ShoppingListRepository {
        return mock()
    }

    private fun failureRepository(): ShoppingListRepository {
        return mock {
            onBlocking { save(any()) } doThrow IllegalArgumentException()
        }
    }

    private fun successDomainService(): CreateListDomainService {
        val mock = mock<CreateListDomainService>()
        val successEvent = CreateDomainEvent.ShoppingListCreated(
            ShoppingList(ListId.generate(), "")
        )
        whenever(mock.create(any())).thenReturn(successEvent)

        return mock
    }

    private fun failureDomainService(): CreateListDomainService {
        val mock = mock<CreateListDomainService>()
        whenever(mock.create(any())).thenReturn(CreateDomainEvent.Failure)

        return mock
    }

    private fun getUseCase(
        domainService: CreateListDomainService,
        repository: ShoppingListRepository
    ): CreateListUseCase {
        return CreateListApplicationService(domainService, repository)
    }
}