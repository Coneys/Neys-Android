package com.github.coneys.neys.shoppingList.create

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import com.github.coneys.androidArchitecture.error.ApplicationError
import com.github.coneys.neys.R
import com.github.coneys.neys.extensions.showOnTextView
import com.github.coneys.neys.shoppingList.CreateApplicationEventBus
import com.github.coneys.neys.shoppingList.create.viewData.CreateListViewState
import com.github.coneys.shoppinglist.application.create.CreateApplicationEvent
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_create_new_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class CreateShoppingListDialog : BottomSheetDialogFragment() {
    private val viewModel by sharedViewModel<CreateListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_new_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClicks()

        setupViewModel()

        setupEventListener()

        setupKeyboard()
    }

    private fun setupKeyboard() {
        create_new_list_dialog_text.requestFocus()
    }



    private fun setupEventListener() {
        CreateApplicationEventBus.subject.observe(viewLifecycleOwner, ::resolveEvent)
    }

    private fun resolveEvent(event: CreateApplicationEvent) {
        when (event) {
            is CreateApplicationEvent.ShoppingListCreated -> {
                dismiss()
            }
        }
    }

    private fun setupViewModel() {
        viewModel.statePublisher.observe(viewLifecycleOwner, ::renderViewState)
    }

    private fun renderViewState(viewState: CreateListViewState) {
        when {
            viewState.showLoading -> renderProgress()
            viewState.error != null -> renderError(viewState.error)
        }
    }

    private fun renderProgress() {
        create_new_list_submit_button.showingProgress = true
        create_new_list_dialog_error_field.text = ""
    }

    private fun renderError(error: ApplicationError) {
        error.showOnTextView(create_new_list_dialog_error_field)
        create_new_list_submit_button.showingProgress = false
    }

    private fun setupClicks() {
        create_new_list_submit_button.onButtonClicked {
            viewModel.create(create_new_list_dialog_text.text.toString())
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        startKeyboard(dialog)
        fixLandscapeOrientation(dialog)

        return dialog
    }

    private fun startKeyboard(dialog: Dialog) {
        dialog.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    private fun fixLandscapeOrientation(dialog: Dialog) {
        dialog.setOnShowListener {
            val bottomSheet = dialog.findViewById<View>(
                com.google.android.material.R.id.design_bottom_sheet
            ) as FrameLayout
            val behavior = BottomSheetBehavior.from(bottomSheet)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}

