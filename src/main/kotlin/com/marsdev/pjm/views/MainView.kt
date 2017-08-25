package com.marsdev.pjm.views

import com.marsdev.pjm.app.Styles
import com.marsdev.pjm.controllers.PJMDataMinerController
import com.marsdev.pjm.javafx.controls.HamburgerMenuPane
import javafx.geometry.Pos
import javafx.scene.CacheHint
import javafx.scene.control.Button
import javafx.scene.control.ContentDisplay
import javafx.scene.paint.Color
import tornadofx.*

class MainView : View("PJM Data Miner 2.0") {

    val controller: PJMDataMinerController by inject()
    val commandBarPane = HamburgerMenuPane()
    val borderPane = borderpane()
    val expandButton = Button("Expand")

    override val root = anchorpane {
        prefWidth = 1000.0
        prefHeight = 800.0
    }

    init {
        expandButton.setOnAction { controller.handleExpandCommandBar() }
        expandButton.anchorpaneConstraints {
            leftAnchor = 0.0
            rightAnchor = 0.0
            topAnchor = 0.0
        }
        expandButton.addClass(Styles.hamburger)
        expandButton.graphic = hbox {
            addClass(Styles.hamburgerMenuGraphic)
            vbox {
                alignment = Pos.CENTER
                spacing = 3.0
                line { endX = 15.0 }
                line { endX = 15.0 }
                line { endX = 15.0 }
            }
        }


        expandButton.contentDisplay = ContentDisplay.GRAPHIC_ONLY
        expandButton.prefHeight = 40.0

        commandBarPane.anchorpaneConstraints {
            bottomAnchor = 0.0
            leftAnchor = 0.0
            topAnchor = 0.0
        }
        commandBarPane.add(expandButton)
        commandBarPane.cacheHint = CacheHint.SPEED
        commandBarPane.cacheProperty().set(true)
        commandBarPane.minWidthProperty().bind(controller.commandBarWidth)
        commandBarPane.prefWidthProperty().bind(controller.commandBarWidth)
        commandBarPane.expanded.bind(controller.commandBarExpanded)
        commandBarPane.style {
            backgroundColor += c("#64B5F6")
            stroke = Color.WHITE
            fill = Color.WHITE
        }

        borderPane.center = label("Content")
        borderPane.anchorpaneConstraints {
            topAnchor = 0.0
            bottomAnchor = 0.0
            leftAnchor = 48.0
            rightAnchor = 0.0
        }


        root += commandBarPane
        root += borderPane
    }
}