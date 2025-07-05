package com.example.booklist

import BookViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.booklist.data.Book
import com.example.booklist.ui.screens.AddBookScreen
import com.example.booklist.ui.screens.BookListScreen
import com.example.booklist.ui.screens.EditBookScreen
import com.example.booklist.ui.theme.BookListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BookListApp()
                }
            }
        }
    }
}

sealed class Screen {
    object List : Screen()
    object Add : Screen()
    data class Edit(val book: Book) : Screen()
}

@Composable
fun BookListApp() {
    val viewModel: BookViewModel = viewModel()
    var currentScreen by remember { mutableStateOf<Screen>(Screen.List) }

    when (val screen = currentScreen) {
        is Screen.List -> BookListScreen(
            viewModel = viewModel,
            onAddBook = { currentScreen = Screen.Add },
            onEditBook = { book ->
                viewModel.prepareForEdit(book)
                currentScreen = Screen.Edit(book)
            }
        )

        is Screen.Add -> AddBookScreen(
            viewModel = viewModel,
            onBack = { currentScreen = Screen.List }
        )

        is Screen.Edit -> EditBookScreen(
            book = screen.book,
            viewModel = viewModel,
            onSave = {
                viewModel.updateBook()
                currentScreen = Screen.List
            },
            onBack = { currentScreen = Screen.List }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookListAppPreview() {
    BookListTheme {
        BookListApp()
    }
}