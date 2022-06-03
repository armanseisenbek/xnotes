package com.onepercent.core.common.util

sealed class OrderType {

    object Ascending: OrderType()

    object Descending: OrderType()
}
