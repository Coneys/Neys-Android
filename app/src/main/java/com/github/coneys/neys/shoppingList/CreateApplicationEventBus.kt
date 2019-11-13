package com.github.coneys.neys.shoppingList

import com.github.coneys.androidArchitecture.subject.LiveEventSubject
import com.github.coneys.shoppinglist.application.create.CreateApplicationEvent

object CreateApplicationEventBus {
    val subject = LiveEventSubject<CreateApplicationEvent>()
}