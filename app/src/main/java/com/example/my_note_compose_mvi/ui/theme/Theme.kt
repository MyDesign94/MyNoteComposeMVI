package com.example.my_note_compose_mvi.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.my_note_compose_mvi.R

@Composable
fun MainTheme(
    style: NoteStyle = NoteStyle.Purple,
    textSize: NoteSize = NoteSize.Medium,
    paddingSize: NoteSize = NoteSize.Medium,
    corners: NoteCorners = NoteCorners.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (darkTheme) {
        true -> {
            when (style) {
                NoteStyle.Purple -> purpleDarkPalette
                NoteStyle.Blue -> blueDarkPalette
                NoteStyle.Orange -> orangeDarkPalette
                NoteStyle.Red -> redDarkPalette
                NoteStyle.Green -> greenDarkPalette
            }
        }
        false -> {
            when (style) {
                NoteStyle.Purple -> purpleLightPalette
                NoteStyle.Blue -> blueLightPalette
                NoteStyle.Orange -> orangeLightPalette
                NoteStyle.Red -> redLightPalette
                NoteStyle.Green -> greenLightPalette
            }
        }
    }

    val typography = NoteTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                NoteSize.Small -> 24.sp
                NoteSize.Medium -> 28.sp
                NoteSize.Big -> 32.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                NoteSize.Small -> 14.sp
                NoteSize.Medium -> 16.sp
                NoteSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                NoteSize.Small -> 14.sp
                NoteSize.Medium -> 16.sp
                NoteSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                NoteSize.Small -> 10.sp
                NoteSize.Medium -> 12.sp
                NoteSize.Big -> 14.sp
            }
        )
    )

    val shapes = NoteShape(
        padding = when (paddingSize) {
            NoteSize.Small -> 12.dp
            NoteSize.Medium -> 16.dp
            NoteSize.Big -> 20.dp
        },
        cornersStyle = when (corners) {
            NoteCorners.Flat -> RoundedCornerShape(0.dp)
            NoteCorners.Rounded -> RoundedCornerShape(8.dp)
        }
    )

    val images = NoteImage(
        mainIcon = if (darkTheme) R.drawable.ic_baseline_mood_24 else R.drawable.ic_baseline_mood_bad_24,
        mainIconDescription = if (darkTheme) "Good Mood" else "Bad Mood"
    )

    CompositionLocalProvider(
        LocalNoteColors provides colors,
        LocalNoteTypography provides typography,
        LocalNoteShape provides shapes,
        LocalNoteImage provides images,
        content = content
    )
}