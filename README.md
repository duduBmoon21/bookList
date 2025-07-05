# 📚 BookList - Native Android Development (Kotlin & Jetpack Compose) – Workshop Assignment

A Modern Android application built with Jetpack Compose for book collection with beautiful Material 3 design.

## ✨ Features

* **Material Design** - Dynamic colors, adaptive theming, and modern UI components
* **Intuitive Book Management** - Add, edit, and remove books with ease
* **Modern Architecture** - Built with MVVM pattern and Jetpack components
* **Dark/Light Theme** - Automatic system theme adaptation

## 💠 Technologies

* Kotlin
* Jetpack Compose
* Material Design 3
* ViewModel

## 🎨 UI/UX Highlights

```kotlin
  OutlinedTextField(
                value = viewModel.currentBookTitle,
                onValueChange = { viewModel.updateTitle(it) },
                label = { Text(stringResource(R.string.book_title)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("title_field"),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Next
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                shape = MaterialTheme.shapes.large
            )
```

## 📸 Screenshots

| Add Book Screen                                                                        | Book List                                                                                | Edit Book                                                                                |
| -------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- |
| ![Add Book](https://github.com/duduBmoon21/bookList/blob/main/static/add.png?raw=true) | ![Book List](https://github.com/duduBmoon21/bookList/blob/main/static/list.png?raw=true) | ![Edit Book](https://github.com/duduBmoon21/bookList/blob/main/static/edit.png?raw=true) |

## 🚀 Getting Started

**Clone the repository**

```bash
git clone https://github.com/duduBmoon21/bookList.git
```

**Open in Android Studio**

**Build and run** on your device/emulator

## 📝 License

MIT License

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

Built with ❤️ by [Eleanor Tefera](https://github.com/duduBmoon21)
