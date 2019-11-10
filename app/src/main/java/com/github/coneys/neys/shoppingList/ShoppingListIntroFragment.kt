package com.github.coneys.neys.shoppingList

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.github.coneys.neys.R
import com.jaredrummler.android.widget.AnimatedSvgView
import kotlinx.android.synthetic.main.fragment_shopping_list_intro.*

class ShoppingListIntroFragment : Fragment(R.layout.fragment_shopping_list_intro) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       shopping_list_intro_state_view.renderProgress()
        /*
        }*/

    }
}