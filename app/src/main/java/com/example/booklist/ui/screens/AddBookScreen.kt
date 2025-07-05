package com.example.booklist.ui.screens

import BookViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.example.booklist.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBookScreen(
    viewModel: BookViewModel,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.add_new_book),
                        style = MaterialTheme.typography.headlineSmall
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

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

            // Author Field
            OutlinedTextField(
                value = viewModel.currentBookAuthor,
                onValueChange = { viewModel.updateAuthor(it) },
                label = { Text(stringResource(R.string.author_name)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("author_field"),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Done
                ),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    focusedLabelColor = MaterialTheme.colorScheme.primary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                shape = MaterialTheme.shapes.large
            )

            Spacer(modifier = Modifier.weight(1f))

            // Add Button
            Button(
                onClick = {
                    if (viewModel.currentBookTitle.isNotBlank() &&
                        viewModel.currentBookAuthor.isNotBlank()) {
                        viewModel.addBook()
                        onBack()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .testTag("add_button"),
                enabled = viewModel.currentBookTitle.isNotBlank() &&
                        viewModel.currentBookAuthor.isNotBlank(),
                shape = MaterialTheme.shapes.large,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    disabledContainerColor = MaterialTheme.colorScheme.surfaceVariant,
                    disabledContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 2.dp,
                    pressedElevation = 8.dp,
                    disabledElevation = 0.dp
                )
            ) {
                Text(
                    text = stringResource(R.string.add_book),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}