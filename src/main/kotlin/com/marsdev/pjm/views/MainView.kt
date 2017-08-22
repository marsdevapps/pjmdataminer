package com.marsdev.pjm.views

import tornadofx.*

class MainView : View("PJM Data Miner 2.0") {

    override val root = borderpane {
        prefWidth = 800.0
        prefHeight = 800.0
        center(ContentView::class)
        left(NavMenuView::class)
    }
}