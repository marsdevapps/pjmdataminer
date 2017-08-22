package com.marsdev.pjm.views

import com.marsdev.pjm.app.Styles
import com.marsdev.pjm.controllers.PJMDataMinerController
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIcon
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView
import javafx.geometry.Side
import tornadofx.*
import tornadofx.control.ListItem
import tornadofx.control.ListMenu

class NavMenuView : View("Navigation Menu") {
    val controller: PJMDataMinerController by inject()
    override val root = vbox()
    val pnodesItem = ListItem("PNodes", mdIcon(MaterialDesignIcon.CHART_BUBBLE)).addClass(Styles.listItem)
    val listMenu = ListMenu(pnodesItem).addClass(Styles.listMenu)

    init {
        listMenu.iconPosition = Side.TOP

        with(root) {
            addClass(Styles.navPane)
        }

        pnodesItem.setOnMouseClicked { controller.showPnodeView() }
        add(listMenu)
    }

    private fun icon(user: FontAwesomeIcon): FontAwesomeIconView {
        val iconview = FontAwesomeIconView(user)
        iconview.setGlyphSize(35)
        return iconview
    }

    private fun mdIcon(icon: MaterialDesignIcon): MaterialDesignIconView {
        val iconview = MaterialDesignIconView(icon)
        iconview.setGlyphSize(35)
        return iconview
    }
}