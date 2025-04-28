package com.nicolas.compose_price_formatter.utility

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.NumberFormat
import java.util.Locale

class CurrencyVisualTransformation : VisualTransformation {

    private val currencyFormatter = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    override fun filter(text: AnnotatedString): TransformedText {
        val cleanString = text.text.replace(Regex("[^0-9]"), "")
        val parsed = cleanString.toBigDecimalOrNull()?.divide(100.toBigDecimal()) ?: "0".toBigDecimal()
        val formattedText = currencyFormatter.format(parsed)

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                val additionalChars = formattedText.length - cleanString.length
                return (offset + additionalChars).coerceAtMost(formattedText.length)
            }

            override fun transformedToOriginal(offset: Int): Int {
                val additionalChars = formattedText.length - cleanString.length
                return (offset - additionalChars).coerceAtLeast(0)
            }
        }

        return TransformedText(AnnotatedString(formattedText), offsetMapping)
    }

    fun formatValue(value: String): String {
        val cleanString = value.replace(Regex("[^0-9]"), "")
        val parsed = cleanString.toBigDecimalOrNull()?.divide(100.toBigDecimal()) ?: "0".toBigDecimal()
        return currencyFormatter.format(parsed)
    }
}