package com.marsdev.pjm.views

import com.marsdev.pjm.controllers.PJMDataMinerController
import com.marsdev.pjm.models.Topic
import tornadofx.*


class TopicView : View("Topics") {
    val controller: PJMDataMinerController by inject()

    override val root = borderpane {

        center = (
                listview<Topic> {
                    //                    items = controller.getTopics().observable()
                }
                )
    }
}