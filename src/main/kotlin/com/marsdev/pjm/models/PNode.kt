package com.marsdev.pjm.models

import tornadofx.*
import javax.json.JsonObject

/**
 * https://dataminer.pjm.com/dataminer/rest/public/api/markets/pnodes?startDate=12/1/2016&endDate=12/4/2016&distinct=true
 */
class PNode : JsonModel, Comparable<PNode> {

    var pnodeId by property<Long>()
    fun pnodeIdProperty() = getProperty(PNode::pnodeId)

    var pnodeName by property<String>()
    fun pnodeNameProperty() = getProperty(PNode::pnodeName)

    // todo add the rest of the pnode properties...

    override fun compareTo(other: PNode): Int {
        return pnodeName.compareTo(other.pnodeName)
    }

    override fun updateModel(json: JsonObject) {
        with(json) {
            pnodeId = long("pnodeId")
            pnodeName = string("pnodeName")
        }
    }

    override fun toString(): String {
        return pnodeName
    }
}