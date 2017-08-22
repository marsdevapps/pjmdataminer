package com.marsdev.pjm.views

import com.marsdev.pjm.app.Styles
import javafx.scene.layout.StackPane
import tornadofx.*

class ContentView : View("Content") {
    override val root = stackpane {
        addClass(Styles.contentPane)

    }

    fun getContentPane(): StackPane {
        return root
    }
}