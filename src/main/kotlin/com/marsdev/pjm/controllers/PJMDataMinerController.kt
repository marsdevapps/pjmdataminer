package com.marsdev.pjm.controllers

import com.marsdev.pjm.models.PNode
import com.marsdev.pjm.models.Topic
import tornadofx.*
import java.time.LocalDate
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

    fun getPnodes(startDate: LocalDate, endDate: LocalDate, distinct: Boolean): MutableList<PNode> {
//        val params = mapOf("effectiveDate" to startDate, "endDate" to endDate, "distinct" to distinct)
        val req: JsonObject? = api.get("/pnode").list().getJsonObject(0)
        val items: JsonArray? = req?.get("items") as JsonArray?
        return items?.toModel<PNode>()!!
//        return api.get("/pnode").list().toModel<PNode>()
    }
}