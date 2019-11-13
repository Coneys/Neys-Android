package com.github.coneys.neys.shoppingList

import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.github.coneys.androidArchitecture.error.ApplicationError
import com.github.coneys.neys.R
import com.github.coneys.neys.shoppingList.listViews.ShoppingListViewHolderManager
import com.github.coneys.neys.shoppingList.viewData.ShoppingListViewState
import com.github.coneys.shoppinglist.application.create.CreateApplicationEvent
import kotlinx.android.synthetic.main.fragment_shopping_list_intro.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShoppingListIntroFragment : Fragment(R.layout.fragment_shopping_list_intro) {

    private val shoppingListIntroViewModel by viewModel<ShoppingListIntroViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shopping_list_intro_state_view.showProgress()

        setupRecycler()

        setupViewModel()

        setupEventListener()
    }

    private fun setupEventListener() {
        CreateApplicationEventBus.subject.observe(viewLifecycleOwner, ::resolveEvent)
    }

    private fun resolveEvent(event: CreateApplicationEvent) {
        when (event) {
            is CreateApplicationEvent.ShoppingListCreated -> {
                shoppingListIntroViewModel.reloadHeaders()
            }
            CreateApplicationEvent.CouldNotCreateList -> {
            }
            CreateApplicationEvent.CouldNotSaveList -> {
            }
        }
    }

    private fun setupRecycler() {
        shopping_list_intro_recycler.initialize(ShoppingListViewHolderManager())
    }

    private fun setupViewModel() {
        shoppingListIntroViewModel.statePublisher.observe(viewLifecycleOwner, ::renderViewState)
        shoppingListIntroViewModel.loadInitial()
    }

    private fun renderViewState(viewState: ShoppingListViewState) {

        viewState.apply {
            when {
                showSuccess -> renderSuccess()
                showLoading -> renderLoading()
                error != null -> renderError(error)
            }
        }

        shopping_list_intro_recycler.submitList(viewState.listViews.toMutableList())

    }

    private fun renderError(error: ApplicationError) {
        shopping_list_intro_state_view.showError(R.drawable.ic_error, R.string.app_name)
    }

    private fun renderLoading() {
        shopping_list_intro_recycler.isGone = true
        shopping_list_intro_state_view.showProgress()
    }

    private fun renderSuccess() {
        shopping_list_intro_recycler.isGone = false
        shopping_list_intro_state_view.hide()
    }

}