package com.marsdev.pjm.app

import javafx.scene.paint.Color
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val navPane by cssclass()
        val contentPane by cssclass()
        val listMenu by cssclass()
        val listItem by cssclass()
        val active by csspseudoclass()

        val B_50 = c("#E3F2FD")
        val B_100 = c("#BBDEFB")
        val B_200 = c("#90CAF9")
        val B_300 = c("#64B5F6")
        val B_400 = c("#42A5F5")
        val B_500 = c("#2196F3")
        val B_600 = c("#1E88E5")
        val B_700 = c("#1976D2")
        val B_800 = c("#1565C0")
        val B_900 = c("#0D47A1")
    }

    init {
        navPane {
            backgroundColor += B_500
        }

        contentPane {
            backgroundColor += Color.WHITE
        }

        listMenu {
            padding = box(8.px)
            backgroundColor += B_500
//            graphicFixedSize = 2.5.em
        }

        listItem contains star {
            fill = Color.WHITE
        }
        listItem {
            padding = box(20.px)
            prefWidth = 180.px
            backgroundColor += B_500
            and(active) {
                backgroundColor += B_900
            }
            and(hover) {
                backgroundColor += B_300
            }
        }
    }
}