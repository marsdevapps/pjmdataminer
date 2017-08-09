package com.marsdev.pjm.controllers

import com.marsdev.pjm.models.PNode
import com.marsdev.pjm.models.Topic
import tornadofx.*
import java.time.LocalDate

class PJMDataMinerController : Controller() {
    val api: Rest by inject()

    init {
        api.baseURI = "https://dataminer.pjm.com/dataminer/rest/public/api/"
    }

    fun getTopics(): MutableList<Topic> = api.get("topics").list().toModel<Topic>()

    fun getPnodes(startDate: LocalDate, endDate: LocalDate, distinct: Boolean): MutableList<PNode> {
        val params = mapOf("startDate" to startDate, "endDate" to endDate, "distinct" to distinct)
        return api.get("markets/pnodes${params.queryString}").list().toModel<PNode>()
    }
}