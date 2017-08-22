package com.marsdev.pjm.views

import tornadofx.*

class MainView : View("Main View") {

    override val root = borderpane {
        //        center(TopicView::class)
        left(PnodeView::class)
    }
}