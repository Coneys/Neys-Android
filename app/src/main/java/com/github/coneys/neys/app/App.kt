package com.github.coneys.neys.app

import android.app.Application
import com.github.coneys.neys.shoppingList.ShoppingListAppComponent
import com.github.coneys.shoppinglist.application.ShoppingListComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = ShoppingListAppComponent.gatherModules()
        startKoin {
            modules(modules)
            androidContext(this@App)
        }
    }
}