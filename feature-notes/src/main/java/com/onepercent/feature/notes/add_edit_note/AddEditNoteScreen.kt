package com.onepercent.feature.notes.add_edit_note

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.onepercent.core.ui.theme.noteColors
import com.onepercent.feature.notes.add_edit_note.components.AddEditNoteTopAppBar
import com.onepercent.feature.notes.navigation.NotesNavItem
import kotlinx.coroutines.launch

//import androidx.compose.animation.Animatable
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Save
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.toArgb
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavController
//
//import com.onepercent.xnotes.feature_note.presentation.add_edit_note.components.TransparentHintTextField
//import com.onepercent.xnotes.ui.theme.noteColors
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch


@Composable
fun AddEditNoteScreen(
//    state: AddEditNoteState,
    viewModel: AddEditNoteViewModel = hiltViewModel(),
    noteColor: Int,
    onEvent: (AddEditNoteEvent) -> Unit = viewModel::onEvent
) {
    val noteBackgroundAnimatable = remember {
        Animatable(
            Color(if (noteColor != -1) noteColor else viewModel.noteColor.value)
        )
    }

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            AddEditNoteTopAppBar {
            }
            Spacer(modifier = Modifier.height(25.dp))
            Column(modifier = Modifier.padding(horizontal = 15.dp)) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = viewModel.noteTitle.value.text,
                    onValueChange = {
                        onEvent(AddEditNoteEvent.EnteredTitle(it))
                    }
                )
                Spacer(modifier = Modifier.height(25.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    value = viewModel.noteContent.value.text,
                    onValueChange = {
                        onEvent(AddEditNoteEvent.EnteredContent(it))
                    }
                )
            }
        }

//        Column(
//            modifier = Modifier.background(noteBackgroundAnimatable.value)
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                content = {
//                    noteColors.forEach { color ->
//                        val colorInt = color.toArgb()
//                        Box(
//                            modifier = Modifier
//                                .size(50.dp)
//                                .shadow(15.dp, CircleShape)
//                                .clip(CircleShape)
//                                .background(color)
//                                .border(
//                                    width = 3.dp,
//                                    color = if (viewModel.noteColor.value == colorInt) {
//                                        Color.Black
//                                    } else Color.Transparent,
//                                    shape = CircleShape
//                                )
//                                .clickable {
//                                    scope.launch {
//                                        noteBackgroundAnimatable.animateTo(
//                                            targetValue = Color(colorInt),
//                                            animationSpec = tween(
//                                                durationMillis = 500
//                                            )
//                                        )
//                                    }
//                                    onEvent(AddEditNoteEvent.ChangeColor(colorInt))
//                                }
//                        )
//                    }
//                }
//            )
//            TextField(
//                value = viewModel.noteTitle.value.text,
//                onValueChange = {
//                    onEvent(AddEditNoteEvent.EnteredTitle(it))
//                }
//            )
//            TextField(
//                value = viewModel.noteContent.value.text,
//                onValueChange = {
//                    onEvent(AddEditNoteEvent.EnteredContent(it))
//                }
//            )
//        }
    }
}


//@Composable
//fun AddEditNoteScreen(
//    navController: NavController,
//    noteColor: Int,
//    viewModel: AddEditNoteViewModel = hiltViewModel()
//) {
//    val titleState = viewModel.noteTitle.value
//    val contentState = viewModel.noteContent.value
//
//    val scaffoldState = rememberScaffoldState()
//
//    val noteBackgroundAnimatable = remember {
//        Animatable(
//            Color(if (noteColor != -1) noteColor else viewModel.noteColor.value)
//        )
//    }
//    val scope = rememberCoroutineScope()
//
//    LaunchedEffect(key1 = true) {
//        viewModel.eventFlow.collectLatest { event ->
//            when(event) {
//                is AddEditNoteViewModel.UiEvent.ShowSnackBar -> {
//                    scaffoldState.snackbarHostState.showSnackbar(
//                        message = event.message
//                    )
//                }
//                is AddEditNoteViewModel.UiEvent.SaveNote -> {
//                    navController.navigateUp()
//                }
//            }
//        }
//    }
//
//    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(
//                onClick = {
//                    viewModel.onEvent(AddEditNoteEvent.SaveNote)
//                },
//                backgroundColor = MaterialTheme.colors.primary
//            ) {
//                Icon(imageVector = Icons.Default.Save, contentDescription = "Save note")
//            }
//        },
//        scaffoldState = scaffoldState
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(noteBackgroundAnimatable.value)
//                .padding(16.dp)
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(8.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                noteColors.forEach { color ->
//                    val colorInt = color.toArgb()
//                    Box(
//                        modifier = Modifier
//                            .size(50.dp)
//                            .shadow(15.dp, CircleShape)
//                            .clip(CircleShape)
//                            .background(color)
//                            .border(
//                                width = 3.dp,
//                                color = if (viewModel.noteColor.value == colorInt) {
//                                    Color.Black
//                                } else Color.Transparent,
//                                shape = CircleShape
//                            )
//                            .clickable {
//                                scope.launch {
//                                    noteBackgroundAnimatable.animateTo(
//                                        targetValue = Color(colorInt),
//                                        animationSpec = tween(
//                                            durationMillis = 500
//                                        )
//                                    )
//                                }
//                                viewModel.onEvent(AddEditNoteEvent.ChangeColor(colorInt))
//                            }
//                    )
//                }
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            TransparentHintTextField(
//                text = titleState.text,
//                hint = titleState.hint,
//                onValueChange = {
//                    viewModel.onEvent(AddEditNoteEvent.EnteredTitle(it))
//                },
//                onFocusChange = {
//                    viewModel.onEvent(AddEditNoteEvent.ChangeTitleFocus(it))
//                },
//                isHintVisible = titleState.isHintVisible,
//                singleLine = true,
//                textStyle = MaterialTheme.typography.h5
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            TransparentHintTextField(
//                text = contentState.text,
//                hint = contentState.hint,
//                onValueChange = {
//                    viewModel.onEvent(AddEditNoteEvent.EnteredContent(it))
//                },
//                onFocusChange = {
//                    viewModel.onEvent(AddEditNoteEvent.ChangeContentFocus(it))
//                },
//                isHintVisible = contentState.isHintVisible,
//                textStyle = MaterialTheme.typography.body1,
//                modifier = Modifier.fillMaxHeight()
//            )
//        }
//    }
//}