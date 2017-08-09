package com.marsdev.pjm.models

import tornadofx.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.json.JsonObject

/**
 * https://dataminer.pjm.com/dataminer/rest/public/api/markets/pnodes?startDate=12/1/2016&endDate=12/4/2016&distinct=true
 *
 *   {
"pnodeId": 98369975,
"pnodeName": "02AMSTED138 KV  TR2",
"areaName": "ATSI",
"pnodeType": "BUS",
"pnodeSubType": "LOAD",
"voltageLevel": "138 KV",
"retiredPnodeId": null,
"effectiveDate": "2011-06-01T04:00:00Z",
"terminationDate": "2017-08-08T04:00:00Z",
"zipCode": null,
"state": null,
"rtDailyLMP": true,
"rtMonthlyLMP": false,
"daDailyLMP": true,
"daMonthlyLMP": false
}
 */
class PNode : JsonModel, Comparable<PNode> {

    var pnodeId by property<Long>()
    fun pnodeIdProperty() = getProperty(PNode::pnodeId)

    var pnodeName by property<String>()
    fun pnodeNameProperty() = getProperty(PNode::pnodeName)

    var areaName by property<String>()
    fun areaNameProperty() = getProperty(PNode::areaName)

    var pnodeType by property<String>()
    fun pnodeTypeProperty() = getProperty(PNode::pnodeType)

    var pnodeSubType by property<String>()
    fun pnodeSubTypeProperty() = getProperty(PNode::pnodeSubType)

    var voltageLevel by property<String>()
    fun voltageLevelProperty() = getProperty(PNode::voltageLevel)

    var retiredPNodeId by property<String>()
    fun retiredPNodeIdProperty() = getProperty(PNode::retiredPNodeId)

    var effectiveDate by property<LocalDateTime>()
    fun effectiveDateProperty() = getProperty(PNode::effectiveDate)

    var terminationDate by property<LocalDateTime>()
    fun terminationDateProperty() = getProperty(PNode::terminationDate)

    var zipCode by property<String>()
    fun zipCodeProperty() = getProperty(PNode::zipCode)

    var state by property<String>()
    fun stateProperty() = getProperty(PNode::state)

    var rtDailyLMP by property<Boolean>()
    fun rtDailyLMPProperty() = getProperty(PNode::rtDailyLMP)

    var daMonthlyLMP by property<Boolean>()
    fun daMonthlyLMPProperty() = getProperty(PNode::daMonthlyLMP)

    var daDailyLMP by property<Boolean>()
    fun daDailyLMPProperty() = getProperty(PNode::daDailyLMP)

    var rtMonthlyLMP by property<Boolean>()
    fun rtMonthlyLMPProperty() = getProperty(PNode::rtMonthlyLMP)

    override fun compareTo(other: PNode): Int {
        return pnodeName.compareTo(other.pnodeName)
    }

    override fun updateModel(json: JsonObject) {
        with(json) {
            pnodeId = long("pnodeId")
            pnodeName = string("pnodeName")
            areaName = string("areaName")
            pnodeType = string("pnodeType")
            pnodeSubType = string("pnodeSubType")
            voltageLevel = string("voltageLevel")
            retiredPNodeId = string("retiredPNodeId")
            effectiveDate = LocalDateTime.parse(getString("effectiveDate"), df)
            terminationDate = LocalDateTime.parse(getString("terminationDate"), df)
            zipCode = string("zipCode")
            state = string("state")
            rtDailyLMP = bool("rtDailyLMP")
            rtMonthlyLMP = bool("rtMonthlyLMP")
            daDailyLMP = bool("daDailyLMP")
            daMonthlyLMP = bool("daMonthlyLMP")
        }
    }

    override fun toString(): String {
        return "$pnodeName ($pnodeId)"
    }

    companion object {
        val df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[XXX][X]")
    }
}