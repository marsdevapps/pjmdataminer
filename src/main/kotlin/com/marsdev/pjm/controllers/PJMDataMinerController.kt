package com.marsdev.pjm.controllers

import com.marsdev.pjm.models.PNode
import com.marsdev.pjm.models.Settings
import com.marsdev.pjm.views.ContentView
import com.marsdev.pjm.views.PNodeView
import com.marsdev.pjm.views.SettingsView
import javafx.animation.Animation
import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.animation.Timeline
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.scene.layout.AnchorPane
import javafx.util.Duration
import tornadofx.*
import javax.json.JsonArray
import javax.json.JsonObject

class PJMDataMinerController : Controller() {
    private var showTimeline: Timeline? = null
    private var hideTimeline: Timeline? = null
    private val collapsedWidth = 48.0
    private val expandedWidth = 200.0
    private val animationDuration = 50
    val commandBarExpanded = SimpleBooleanProperty(false)
    val commandBarWidth = SimpleDoubleProperty(48.0)


    val api: Rest by inject()
    val settings = Settings()
    val contentView: ContentView by inject()
    val pnodeView: PNodeView by inject()
    val settingsView: SettingsView by inject()

    init {
        api.baseURI = "https://api.pjm.com/api/v1/"
        api.engine.requestInterceptor = { request ->
            request.addHeader("Ocp-Apim-Subscription-Key", settings.apiKey)
        }

        settings.apiKeyProperty().set(config.string("apikey"))
    }

    fun getPnodes(rowCount: Int, startRow: Int): MutableList<PNode> {
        val params = mapOf("rowCount" to rowCount, "startRow" to startRow)
        val jsonResponse: JsonObject? = api.get("/pnode${params.queryString}").list().getJsonObject(0)
        val items: JsonArray? = jsonResponse?.get("items") as JsonArray?
        return items?.toModel<PNode>()!!
    }

    fun showPNodeView() {
        contentView.getContentPane().children.setAll(pnodeView.root)
    }

    fun showSettingsView() {
        contentView.getContentPane().children.setAll(settingsView.root)
    }

    fun saveSettings() {
        with(config) {
            set("apikey" to settings.apiKey)
            save()
        }
    }

    fun handleExpandCommandBar() {
        if (commandBarExpanded.get()) {
            println("Expanded")
            hideCommandBar()
        } else {
            println("Not Expanded")
            showCommandBar()
        }
    }

    private fun hideCommandBar() {
        if (showTimeline != null) {
            showTimeline?.stop()
        }

        if (hideTimeline != null && hideTimeline?.status == Animation.Status.RUNNING) {
            return
        }
        if (commandBarWidth.get() <= collapsedWidth) {
            return
        }
        val duration = Duration.millis(animationDuration.toDouble())
        hideTimeline = Timeline(KeyFrame(duration, KeyValue(commandBarWidth, collapsedWidth)))
        AnchorPane.setLeftAnchor(contentView.root, collapsedWidth)
        hideTimeline?.play()
        commandBarExpanded.set(false)
    }

    private fun showCommandBar() {
        if (hideTimeline != null) {
            hideTimeline?.stop()
        }
        if (showTimeline != null && showTimeline?.status == Animation.Status.RUNNING) {
            return
        }
        val duration = Duration.millis(animationDuration.toDouble())
        val keyFrame = KeyFrame(duration, KeyValue(commandBarWidth, expandedWidth))
        showTimeline = Timeline(keyFrame)
        showTimeline?.setOnFinished { event -> AnchorPane.setLeftAnchor(contentView.root, expandedWidth) }
        showTimeline?.play()
        commandBarExpanded.set(true)
    }
}