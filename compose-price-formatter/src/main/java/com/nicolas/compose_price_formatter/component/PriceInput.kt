package com.nicolas.compose_price_formatter.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.nicolas.compose_price_formatter.utility.CurrencyVisualTransformation

@Composable
fun PriceInput(
    modifier: Modifier = Modifier,
    price: String,
    onPriceChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(
        fontSize = MaterialTheme.typography.titleLarge.fontSize,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Center,
        fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
        fontWeight = FontWeight.Medium
    ),
    textFieldColor: TextFieldColors = TextFieldDefaults.colors(),
    hint: String = "R$ 0,00"
) {

    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }

    TextField(
        value = price,
        onValueChange = { newValue ->
            if (newValue.isDigitsOnly()) {
                onPriceChange(newValue)
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),
        textStyle = textStyle.copy(
            color = MaterialTheme.colorScheme.primary.copy(
                alpha = if (price.isNotBlank() || isFocused) 0.8f else 0.4f
            ),
        ),
        colors = textFieldColor,
        placeholder = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = hint,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary.copy(),
                textAlign = TextAlign.Center,
                fontFamily = MaterialTheme.typography.titleLarge.fontFamily,
            )
        },
        visualTransformation = CurrencyVisualTransformation(),
        maxLines = 1,
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged { isFocused = it.isFocused }
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.surfaceContainerLow)
            .padding(horizontal = 20.dp, vertical = 10.dp),
    )
}
