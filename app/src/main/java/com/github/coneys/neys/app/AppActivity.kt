package com.github.coneys.neys.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.coneys.neys.R
import com.github.coneys.neys.extensions.onClick
import com.github.coneys.neys.shoppingList.create.CreateShoppingListDialog
import com.google.android.material.shape.MaterialShapeDrawable
import kotlinx.android.synthetic.main.activity_app.*


class AppActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        setupBottomAppBarCutCornersBackground()

        setupFab()


    }

    private fun setupFab() {

        main_app_fab.onClick {
            CreateShoppingListDialog().show(supportFragmentManager, null)
        }
    }

    private fun setupBottomAppBarCutCornersBackground() {
        val topEdge = BottomAppBarCutCornersTopEdge(
            bottom_app_bar.fabCradleMargin,
            bottom_app_bar.fabCradleRoundedCornerRadius,
            bottom_app_bar.cradleVerticalOffset
        )
        val background = bottom_app_bar.background as MaterialShapeDrawable
        background.shapeAppearanceModel =
            background.shapeAppearanceModel.toBuilder().setTopEdge(topEdge).build()
        background.invalidateSelf()
    }
}
