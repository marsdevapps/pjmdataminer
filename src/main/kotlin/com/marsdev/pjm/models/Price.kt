package com.marsdev.pjm.models

import tornadofx.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.json.JsonObject

class Price : JsonModel, Comparable<Price> {

    var utcHour by property<LocalDateTime>()
    fun utcHourProperty() = getProperty(Price::utcHour)

    var price by property<Double>()
    fun priceProperty() = getProperty(Price::price)

    override fun updateModel(json: JsonObject) {
        with(json) {
            utcHour = LocalDateTime.parse(getString("utcHour"), df)
            price = double("price")
        }
    }

    override fun toString(): String {
        return prettyDF.format(utcHour)
    }

    override fun compareTo(other: Price): Int {
        return price.compareTo(other.price)
    }

    companion object {
        val df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[XXX][X]")
        val prettyDF = DateTimeFormatter.ofPattern("MM/dd/yyyy HH")
    }
}