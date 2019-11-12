package com.github.coneys.neys.shoppingList.create

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.view.updateLayoutParams
import com.github.coneys.neys.R
import com.github.coneys.neys.extensions.onClick
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_create_new_list.*
import kotlinx.android.synthetic.main.view_progress_button.*
import kotlinx.coroutines.*

class CreateShoppingListDialog: BottomSheetDialogFragment()
{
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_create_new_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        create_new_list_submit_button.onButtonClicked {
            create_new_list_submit_button.showingProgress = !create_new_list_submit_button.showingProgress
            GlobalScope.launch {
                withContext(Dispatchers.Main){
                    delay(2000)
                    create_new_list_submit_button.showingProgress=false
                }
            }
        }
    }


    // Fix for landscape mode
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)

        dialog.setOnShowListener {
            val bottomSheet = dialog.findViewById<View>(
                com.google.android.material.R.id.design_bottom_sheet
            ) as FrameLayout
            val behavior = BottomSheetBehavior.from(bottomSheet)
            behavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        return dialog
    }
}

