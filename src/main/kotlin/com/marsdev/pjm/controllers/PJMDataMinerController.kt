package com.marsdev.pjm.controllers

import com.marsdev.pjm.models.PNode
import com.marsdev.pjm.models.Topic
import tornadofx.*
import javax.json.JsonArray
import javax.json.JsonObject

class PJMDataMinerController : Controller() {
    val api: Rest by inject()

    init {
        api.baseURI = "https://api.pjm.com/api/v1/"
        api.engine.requestInterceptor = { request ->
            request.addHeader("Ocp-Apim-Subscription-Key", "")
        }
    }

    fun getTopics(): MutableList<Topic> = api.get("topics").list().toModel<Topic>()

    fun getPnodes(rowCount: Int, startRow: Int): MutableList<PNode> {
        val params = mapOf("rowCount" to rowCount, "startRow" to startRow)
        val jsonResponse: JsonObject? = api.get("/pnode${params.queryString}").list().getJsonObject(0)
        val items: JsonArray? = jsonResponse?.get("items") as JsonArray?
        return items?.toModel<PNode>()!!
    }
}