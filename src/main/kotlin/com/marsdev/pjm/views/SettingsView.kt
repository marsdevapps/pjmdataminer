package com.marsdev.pjm.views

import com.marsdev.pjm.app.Styles
import com.marsdev.pjm.controllers.PJMDataMinerController
import tornadofx.*

class SettingsView : View("Leo Settings") {
    val controller: PJMDataMinerController by inject()

    override val root = Form()

    init {
        with(root) {

            addClass(Styles.contentPane)

            fieldset("PJM Data Miner API Information") {
                field("_API Key") {
                    textfield(controller.settings.apiKeyProperty()).mnemonicTarget()
                }

                button("_Save").setOnAction {
                    controller.saveSettings()
                }
            }

        }
    }
}