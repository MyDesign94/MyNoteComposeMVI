package com.example.my_note_compose_mvi.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class NoteColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color
)

data class NoteTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle
)

data class NoteShape(
    val padding: Dp,
    val cornersStyle: Shape
)

data class NoteImage(
    val mainIcon: Int,
    val mainIconDescription: String
)

object NoteTheme {
    val colors: NoteColors
        @Composable
        get() = LocalNoteColors.current

    val typography: NoteTypography
        @Composable
        get() = LocalNoteTypography.current

    val shapes: NoteShape
        @Composable
        get() = LocalNoteShape.current

    val images: NoteImage
        @Composable
        get() = LocalNoteImage.current
}

enum class NoteStyle {
    Purple, Orange, Blue, Red, Green
}

enum class NoteSize {
    Small, Medium, Big
}

enum class NoteCorners {
    Flat, Rounded
}

val LocalNoteColors = staticCompositionLocalOf<NoteColors> {
    error("No colors provided")
}

val LocalNoteTypography = staticCompositionLocalOf<NoteTypography> {
    error("No font provided")
}

val LocalNoteShape = staticCompositionLocalOf<NoteShape> {
    error("No shapes provided")
}

val LocalNoteImage = staticCompositionLocalOf<NoteImage> {
    error("No images provided")
}