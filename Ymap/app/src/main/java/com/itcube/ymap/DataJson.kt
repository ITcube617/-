package com.itcube.ymap

data class DataJson(
    val iss_position: IssPosition,
    val message: String,
    val timestamp: Int
) {
    data class IssPosition(
        val latitude: String,
        val longitude: String
    )
}