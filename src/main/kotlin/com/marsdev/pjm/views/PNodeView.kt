package com.marsdev.pjm.views

import com.marsdev.pjm.controllers.PJMDataMinerController
import com.marsdev.pjm.models.PNode
import tornadofx.*


class PnodeView : View("Pnodes") {
    val controller: PJMDataMinerController by inject()

    override val root = borderpane {

        center = (
                listview<PNode> {
                    items = controller.getPnodes(9999, 1).observable().sorted()
                }
                )
    }
}