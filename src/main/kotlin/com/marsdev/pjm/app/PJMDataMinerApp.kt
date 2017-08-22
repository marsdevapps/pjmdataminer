package com.marsdev.pjm.app

import com.marsdev.pjm.views.MainView
import tornadofx.*

class PJMDataMinerApp : App(MainView::class, Styles::class) {
    init {
        setStageIcon(resources.image("app-icon.png"))
    }
}