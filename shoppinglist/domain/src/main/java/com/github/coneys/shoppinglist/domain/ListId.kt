package com.github.coneys.shoppinglist.domain

import java.util.*

inline class ListId(val rawValue: UUID) {
    companion object {
        fun generate() = ListId(UUID.randomUUID())
    }
}