package com.example.housebookinapp.Model

import java.io.Serializable

data class ItemsDomain(
    var type: String,
    var title: String,
    var address: String,
    var pickPath: String,
    var bed: Int,
    var bath: Int,
    var price: Int,
    var size: Int,
    var isGarage: Boolean,
    var score:Double,
    var description: String
): Serializable
