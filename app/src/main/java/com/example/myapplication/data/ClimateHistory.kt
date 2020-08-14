package com.example.myapplication.data

class ClimateHistory(
    val history: Array<ClimateHistoryItem>

)

class ClimateHistoryItem(
    val date: Int,
    val value: Int
)