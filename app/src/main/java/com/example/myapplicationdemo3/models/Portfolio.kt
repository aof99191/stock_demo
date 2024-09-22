package com.example.myapplicationdemo3.models

data class Portfolio(
    val planid: String,
    val title: String,
    val enable: Int,
    val order: Int,
    val description: String,
    val image_plan_bg: String,
    val image_plan: String,
    val withdrawable_point: Double,
    val pending_point: Double,
    val cost: Double,
    val change: Double,
    val all: Double,
)