package com.onepercent.xnotes

import androidx.compose.runtime.*

class InvalidNoteException(message: String): Exception(message)

class TestClass() {
    object Factory {

    }
}

class MainTestClass() {

    val test = TestClass.Factory
}

@Composable
fun TestComposable() {


    val mutableState = remember { mutableStateOf("default") }
    var value1 by remember { mutableStateOf("default") }
    val (value2, setValue) = remember { mutableStateOf("default") }

    val list1 = listOf<String>("one", "two")

    val list = mutableListOf<String>("one", "two")

//    list.removeAt()

    mutableState.component1().toString()

    mutableState.value = ""

    value1 = ""

    setValue("" + value2)


}