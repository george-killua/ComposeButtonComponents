# Custom Compose Buttons with Extended Functionality

This repository offers a set of custom button components for Jetpack Compose that enhance the standard Compose `Button` component by introducing support for both regular clicks (`onClick`) and long clicks (`onLongClick`). These buttons are highly customizable and can be effortlessly integrated into your Compose-based projects.

## Features

- **`DCButton`**: A customizable button with regular click and long-click support.
- **`DCElevatedButton`**: An elevated button with regular click and long-click support.
- **`DCFilledTonalButton`**: A filled tonal button with regular click and long-click support.
- **`DCOutlinedButton`**: An outlined button with regular click and long-click support.
- **`DCTextButton`**: A text button with regular click and long-click support.

## Installation

To use these custom button components in your Compose project, follow these steps:

1. Open your project's `build.gradle` file and ensure you have the Compose dependencies included:

```
dependencies {
    // ...
    implementation(platform("androidx.compose:compose-bom:$compose_bom_version"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    // ...
}
```

Replace `$compose_bom_version` with the version of Compose bom you are using.

2. Copy the custom button components (`DCButton.kt`, `DCElevatedButton.kt`, `DCFilledTonalButton.kt`, `DCOutlinedButton.kt`, and `DCTextButton.kt`) into your project's source directory, placing them in a package that aligns with your project's structure.

## Usage

You can use these custom button components just like standard Compose `Button` components. The key difference is that they support both regular clicks and long clicks. Here's an example of how to use them:

```
import com.gkcoding.composebuttoncomponents.component.*

// ...

Column {
    DCButton(
        onClick = { /* Handle regular click event */ },
        onLongClick = { /* Handle long-click event */ }
    ) {
        Text(text = "DCButton")
    }

    DCElevatedButton(
        onClick = { /* Handle regular click event */ },
        onLongClick = { /* Handle long-click event */ }
    ) {
        Text(text = "DCElevatedButton")
    }

    DCFilledTonalButton(
        onClick = { /* Handle regular click event */ },
        onLongClick = { /* Handle long-click event */ }
    ) {
        Text(text = "DCFilledTonalButton")
    }

    DCOutlinedButton(
        onClick = { /* Handle regular click event */ },
        onLongClick = { /* Handle long-click event */ }
    ) {
        Text(text = "DCOutlinedButton")
    }

    DCTextButton(
        onClick = { /* Handle regular click event */ },
        onLongClick = { /* Handle long-click event */ }
    ) {
        Text(text = "DCTextButton")
    }
}
```

In this example, we've created a `Column` that contains instances of each custom button component. For each button, we've provided both `onClick` and `onLongClick` event handlers. These event handlers allow you to define specific actions or behaviors for regular clicks and long clicks on the buttons.

## Customization

These custom button components offer extensive customization options:

- `shape`: Customize the button's shape.
- `colors`: Customize the button's colors.
- `elevation`: Customize the button's elevation for different states.
- `border`: Customize the button's border.
- `contentPadding`: Customize the content padding within the button.
- `enabled`: Control whether the button is enabled or disabled.

Feel free to tailor these properties to match your project's design and requirements.

## License

These custom button components are released under the [MIT License](LICENSE). You are welcome to use and modify them in both personal and commercial projects. If you find them useful, consider giving this repository a star on GitHub and sharing it with others.

If you have any questions or encounter issues, please don't hesitate to open an issue on this repository. Your feedback and contributions are appreciated.

Happy composing! 😊
