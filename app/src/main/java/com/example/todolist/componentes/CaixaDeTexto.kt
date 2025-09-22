package com.example.todolist.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CaixaDeTexto(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    maxLines: Int,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = value,
        onValueChange,
        modifier,
        label = {
            Text(label)
        },
        maxLines = maxLines,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}

@Preview
@Composable
private fun CaixaDeTextoPreview() {
    CaixaDeTexto(
        modifier = Modifier.fillMaxWidth(),
        value = "Gustavo Caetano",
        onValueChange = {},
        label = "Xablau",
        maxLines = 1,
        keyboardType = KeyboardType.Ascii
    )
}