package com.example.todocompose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todocompose.data.models.Priority
import com.example.todocompose.ui.theme.LARGE_PADDING
import com.example.todocompose.ui.theme.PRIORITY_INDICATOR_SIZE

@Composable
fun PriorityItem(priority: Priority){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
            drawCircle(color = priority.color)
        }
        Text(
            modifier = Modifier
                .padding(start = LARGE_PADDING),
            text = priority.name,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = rainbowColors
                )
            )
        )

    }
}

@Composable
@Preview
fun PriorityItemPreview(){
    PriorityItem(priority = Priority.LOW)
}

val rainbowColors = listOf(
    Color.Red,
    Color.Yellow,
    Color.Green,
    Color.Blue,
)