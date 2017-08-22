package com.marsdev.pjm.models

import tornadofx.*

class Settings {

    var apiKey by property<String>()
    fun apiKeyProperty() = getProperty(Settings::apiKey)
}