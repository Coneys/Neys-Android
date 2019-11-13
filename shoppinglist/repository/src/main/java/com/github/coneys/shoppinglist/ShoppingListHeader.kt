package com.github.coneys.shoppinglist

import com.github.coneys.core.ListId

data class ShoppingListHeader(
    val id: ListId,
    val name: String,
    val isFinished: Boolean
)