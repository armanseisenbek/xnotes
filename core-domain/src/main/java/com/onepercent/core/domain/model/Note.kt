package com.onepercent.core.domain.model

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
)