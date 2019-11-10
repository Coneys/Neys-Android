package com.github.coneys.shoppinglist

import java.util.*

inline class ListId(val rawValue: UUID) {
    companion object {
        fun generate() = ListId(UUID.randomUUID())
    }
}