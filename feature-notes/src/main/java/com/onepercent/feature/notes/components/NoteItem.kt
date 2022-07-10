package com.onepercent.feature.notes.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils

import com.onepercent.core.domain.model.Note

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 5.dp,
    cutCornerSize: Dp = 25.dp,
    onNoteClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(cornerRadius))
            .clip(CutCornerShape(bottomEnd = cutCornerSize))
            .background(Color(note.color))
            .clickable {
                onNoteClick()
            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(end = 32.dp),
            content = {
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = note.content,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 10,
                    overflow = TextOverflow.Ellipsis
                )
            }
        )
        IconButton(
            onClick = onDeleteClick,
            modifier = Modifier.align(Alignment.TopEnd),
            content = {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = "Delete note",
                    tint = MaterialTheme.colors.onSurface
                )
            }
        )
        // background
        Canvas(
            modifier = Modifier.matchParentSize(),
            onDraw = {
                drawRoundRect(
                    color = Color(
                        ColorUtils.blendARGB(note.color, 0x0000000, 0.2f)
                    ),
                    topLeft = Offset(
                        size.width - cutCornerSize.toPx(),
                        size.height-cutCornerSize.toPx()
                    ),
                    size = Size(
                        cutCornerSize.toPx() + 100f,
                        cutCornerSize.toPx() + 100f
                    ),
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
            }
        )
    }
}