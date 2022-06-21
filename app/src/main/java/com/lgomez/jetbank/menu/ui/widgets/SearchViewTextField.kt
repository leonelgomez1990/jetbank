package com.lgomez.jetbank.menu.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun SearchViewTextField(
    stateValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    onCloseClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Color.Gray, shape = CircleShape)
            .fillMaxWidth()
    ) {
        BasicTextField(
            value = stateValue,
            onValueChange = onValueChange,
            modifier = Modifier
                .background(Color.White, CircleShape)
                .height(38.dp)
                .fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "image",
                        tint = Color.Blue
                    )
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (stateValue == TextFieldValue("")) Text(
                            "Search"
                        )
                        innerTextField()
                    }
                    if (stateValue != TextFieldValue("")) {
                        IconButton(
                            onClick = onCloseClick,
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "image",
                                tint = Color.Blue
                            )
                        }
                    }
                }
            }
        )
    }
}