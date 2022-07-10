package com.onepercent.core.common

sealed class UIComponent {

    data class Dialog(val title: String, val description: String): UIComponent()

    data class None(val message: String): UIComponent()

    data class SnackBar(val message: String): UIComponent()

    data class Toast(val message: String): UIComponent()

    // snackbar, toast, notification
}
