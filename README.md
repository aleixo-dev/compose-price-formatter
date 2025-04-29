# Compose Price Formatter

![Version](https://img.shields.io/github/v/release/aleixo-dev/compose-price-formatter?style=flat-square) ![Size](https://img.shields.io/github/repo-size/aleixo-dev/compose-price-formatter?style=flat-square)  ![Contributors](https://img.shields.io/github/contributors/aleixo-dev/compose-price-formatter?style=flat-square) ![License](https://img.shields.io/github/license/aleixo-dev/compose-price-formatter?style=flat-square)  

The **PriceInput Compose Component** is an input field for monetary values created to be used in Android apps with Jetpack Compose. It formats the user's input as currency (e.g., "R$ 1,234.56") and offers full customization to fit the style of your app.

## Features

- **Monetary value input**: The component formats the entered value as currency.
- **Input validation**: Only numeric values are accepted.
- **Customizable styles**: You can customize the appearance of the input field with different text styles, colors, and fonts.
- **Placeholder support**: The component supports a placeholder text, such as "R$ 0,00".

## Installation

### Using Jitpack

1. Add the Jitpack repository to your `build.gradle` (project level):

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.aleixo-dev:compose-price-formatter:$version'
}
```

## Usage
### Example
Here is a basic example of how to use the PriceInput component in your Jetpack Compose project:

```kotlin
@Composable
fun MyScreen(modifier : Modifier = Modifier) {
    var price by remember { mutableStateOf("") }

    PriceInput(
        modifier = modifier,
        price = price,
        onPriceChange = { newPrice -> price = newPrice },
        hint = "Enter the price",
        textFieldColor = TextFieldDefaults.colors()
    )
}
```
The price field holds the value the user types, and the onPriceChange function is called whenever the value changes.

## Customization
You can customize the text style and other properties of the PriceInput like this:
```kotlin
PriceInput(
    modifier = modifier.fillMaxWidth(),
    price = price,
    onPriceChange = { newPrice -> price = newPrice },
    textStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Start,
    ),
    hint = "Enter value",
    textFieldColor = TextFieldDefaults.colors(
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                unfocusedContainerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                focusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedTextColor = MaterialTheme.colorScheme.primary,
                unfocusedSupportingTextColor = MaterialTheme.colorScheme.primary
            )
)
```

## Parameters

| Parameter        | Description                                                                                                                                   |
|------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| `modifier`       | Optional modifier to customize the layout of the input field.                                                                                 |
| `price`          | The current value of the price, which is displayed in the input field.                                                                         |
| `onPriceChange`  | A function called whenever the value of the input field changes. This function should update the `price` state.                               |
| `textStyle`      | A text style to customize the appearance of the value. You can change font size, weight, color, and alignment here.                            |
| `hint`           | Placeholder text displayed when the input field is empty.                                                                     |
| `textFieldColors`| Change the default color values used by TextField                                                        |


## Dependencies
This component uses the following Jetpack Compose libraries:
 - Jetpack Compose UI (for building the component)
 - Jetpack Compose Material (for UI elements and themes)
 - Jetpack Compose Foundation (for handling focus and state)

## Contributions
Contributions are welcome! To contribute:

Fork this repository.
1. Create a branch for your feature (git checkout -b feature/new-feature).
2. Commit your changes (git commit -m 'Adding new feature').
3. Push to the remote repository (git push origin feature/new-feature).
4. Open a Pull Request.

# License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## MIT License
```
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
