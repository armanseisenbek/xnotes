package com.onepercent.core.model

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
)