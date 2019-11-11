package com.github.coneys.neys.shoppingList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.coneys.neys.R
import com.github.coneys.neys.shoppingList.listViews.ShoppingListViewHolderManager
import com.github.coneys.neys.shoppingList.viewData.ShoppingListViewState
import kotlinx.android.synthetic.main.fragment_shopping_list_intro.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShoppingListIntroFragment : Fragment(R.layout.fragment_shopping_list_intro) {

    private val shoppingListIntroViewModel by viewModel<ShoppingListIntroViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shopping_list_intro_state_view.renderProgress()

        setupRecycler()

        setupViewModel()
    }

    private fun setupRecycler() {
        shopping_list_intro_recycler.initialize(ShoppingListViewHolderManager())
    }

    private fun setupViewModel() {
        shoppingListIntroViewModel.statePublisher.observe(viewLifecycleOwner,::renderViewState)
        shoppingListIntroViewModel.loadInitial()
    }

    private fun renderViewState(viewState: ShoppingListViewState) {
        shopping_list_intro_recycler.submitList(viewState.listViews.toMutableList())

    }

}