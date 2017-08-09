package com.marsdev.pjm.views

import com.marsdev.pjm.controllers.PJMDataMinerController
import com.marsdev.pjm.models.PNode
import tornadofx.*
import java.time.LocalDate


class PnodeView : View("Pnodes") {
    val controller: PJMDataMinerController by inject()

    override val root = borderpane {

        center = (
                listview<PNode> {
                    items = controller.getPnodes(LocalDate.of(2000, 10, 1), LocalDate.of(9999, 10, 1), true).observable()
                }
                )
    }
}