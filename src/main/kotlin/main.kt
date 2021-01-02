import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset

fun main() {
    val windowPos = mutableStateOf(IntOffset.Zero)

    Window {
        val current = AppWindowAmbient.current

        // Content
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(text = "Location: ${windowPos.value}")
                Button(
                    onClick = {
                        if (current != null) {
                            windowPos.value = IntOffset(current.x, current.y)
                        }
                    }
                ) {
                    Text(text = "Print window location")
                }
            }
        }
    }
}