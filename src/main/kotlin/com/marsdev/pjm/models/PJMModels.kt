package com.marsdev.pjm.models

import tornadofx.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.json.JsonObject

class Topic() : JsonModel {

    var topicId by property<Int>()
    fun topicIdProperty() = getProperty(Topic::topicId)

    var topicName by property<String>()
    fun topicNameProperty() = getProperty(Topic::topicName)

    var description by property<String>()
    fun descriptionProperty() = getProperty(Topic::description)

    var startDate by property<LocalDateTime>()
    fun startDateProperty() = getProperty(Topic::startDate)

    var endDate by property<LocalDateTime>()
    fun endDateProperty() = getProperty(Topic::endDate)

    override fun toString(): String {
        return "Name: $topicName  Id: $topicId  Description: $description  Start: $startDate  End: $endDate"
    }

    override fun updateModel(json: JsonObject) {
        with(json) {
            topicId = int("topicId")
            topicName = string("topicName")
            description = string("description")
            startDate = LocalDateTime.parse(getString("startDate"), df)
            endDate = LocalDateTime.parse(getString("endDate"), df)
        }
    }

    companion object {
        val df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[XXX][X]")
    }
}