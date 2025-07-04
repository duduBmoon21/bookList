package com.example.booklist.ui.screens

import Book
import BookViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.content.Intent

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun BookListScreen(
    viewModel: BookViewModel,
    onAddBook: () -> Unit
) {
    val books = viewModel.books.value
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "My Books",
                style = MaterialTheme.typography.headlineMedium
            )

            Button(onClick = onAddBook) {
                Icon(Icons.Default.Add, contentDescription = "Add")
                Text("Add Book")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total books: ${books.size}",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(books) { book ->
                BookItem(
                    book = book,
                    onRemove = { viewModel.removeBook(book) },
                    onShare = {
                        val intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(
                                Intent.EXTRA_TEXT,
                                "Check out this book: ${book.title} by ${book.author}"
                            )
                            type = "text/plain"
                        }
                        context.startActivity(Intent.createChooser(intent, "Share book"))
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun BookItem(
    book: Book,
    onRemove: () -> Unit,
    onShare: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = book.title,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "by ${book.author}",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onShare,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Text("Share")
                }
                Button(onClick = onRemove) {
                    Text("Remove")
                }
            }
        }
    }
}