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

    var pnodeType by property<String>()
    fun pnodeTypeProperty() = getProperty(PNode::pnodeType)

    var pnodeSubType by property<String>()
    fun pnodeSubTypeProperty() = getProperty(PNode::pnodeSubType)

    var zone by property<String>()
    fun zoneProperty() = getProperty(PNode::zone)

    var voltageLevel by property<String>()
    fun voltageLevelProperty() = getProperty(PNode::voltageLevel)

    var effectiveDate by property<LocalDateTime>()
    fun effectiveDateProperty() = getProperty(PNode::effectiveDate)

    var terminationDate by property<LocalDateTime>()
    fun terminationDateProperty() = getProperty(PNode::terminationDate)


    override fun compareTo(other: PNode): Int {
        return pnodeName.compareTo(other.pnodeName)
    }

    override fun updateModel(json: JsonObject) {
        with(json) {
            pnodeId = long("pnode_id")
            pnodeName = string("pnode_name")
            pnodeType = string("pnode_type")
            pnodeSubType = string("pnode_subtype")
            zone = string("zone")
            voltageLevel = string("voltage_level")
            effectiveDate = LocalDateTime.parse(getString("effective_date"), df)
            terminationDate = LocalDateTime.parse(getString("termination_date"), df)
        }
    }

    override fun toString(): String {
        return "$pnodeName ($pnodeId)"
    }

    companion object {
        val df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[XXX][X]")
    }
}