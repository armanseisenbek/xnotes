package com.onepercent.xnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.onepercent.core.ui.theme.XnotesTheme
import com.onepercent.xnotes.navigation.XnotesNavHost

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            XnotesTheme {
                XnotesNavHost()
            }
        }
    }
}