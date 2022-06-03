package com.onepercent.core.common

sealed class ProgressBarState {

    object Loading: ProgressBarState()
    object Idle: ProgressBarState()
}