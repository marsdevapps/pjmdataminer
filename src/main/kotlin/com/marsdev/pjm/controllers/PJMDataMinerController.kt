package com.marsdev.pjm.controllers

import com.marsdev.pjm.models.Topic
import tornadofx.*

class PJMDataMinerController : Controller() {
    val api: Rest by inject()

    init {
        api.baseURI = "https://dataminer.pjm.com/dataminer/rest/public/api/"
    }

    fun getTopics(): MutableList<Topic> = api.get("topics").list().toModel<Topic>()

}