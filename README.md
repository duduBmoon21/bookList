# 📚 BookList - Modern Android Book Tracking App

A sleek, modern Android application built with Jetpack Compose for tracking your book collection with beautiful Material 3 design.

![App Screenshot](https://github.com/duduBmoon21/bookList/blob/main/static/cover.png?raw=true)

## ✨ Features

* **Material You Design** - Dynamic colors, adaptive theming, and modern UI components
* **Intuitive Book Management** - Add, edit, and remove books with ease
* **Beautiful Animations** - Smooth transitions and interactive elements
* **Modern Architecture** - Built with MVVM pattern and Jetpack components
* **Dark/Light Theme** - Automatic system theme adaptation

## 💠 Technologies

* 100% Kotlin
* Jetpack Compose
* Material Design 3
* ViewModel & StateFlow
* Room Database *(optional - if implemented)*

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

| Add Book Screen                                                                        | Book List                                                                                | Edit Book                                                                                | Confirm Delete                                                                                  |           |           |
| -------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------- | --------- | --------- |
| ![Add Book](https://github.com/duduBmoon21/bookList/blob/main/static/add.png?raw=true) | ![Book List](https://github.com/duduBmoon21/bookList/blob/main/static/list.png?raw=true) | ![Edit Book](https://github.com/duduBmoon21/bookList/blob/main/static/edit.png?raw=true) | ![Confirm Delete](https://github.com/duduBmoon21/bookList/blob/main/static/delete.png?raw=true) | Book List | Edit Book |
| -------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------- |                                                                                                 |           |           |
| ![Add Book](https://github.com/duduBmoon21/bookList/blob/main/static/add.png?raw=true) | ![Book List](https://github.com/duduBmoon21/bookList/blob/main/static/list.png?raw=true) | ![Edit Book](https://github.com/duduBmoon21/bookList/blob/main/static/edit.png?raw=true) |                                                                                                 |           |           |

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
