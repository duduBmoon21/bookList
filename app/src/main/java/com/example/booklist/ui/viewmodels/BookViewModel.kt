import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.booklist.data.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BookViewModel : ViewModel() {
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books = _books.asStateFlow()

    // Track the next available ID
    private var nextId by mutableStateOf(1)

    // Form fields for adding/editing books
    var currentBookTitle by mutableStateOf("")
        private set
    var currentBookAuthor by mutableStateOf("")
        private set
    var currentBookId by mutableStateOf<Int?>(null)
        private set

    fun addBook() {
        if (currentBookTitle.isNotBlank() && currentBookAuthor.isNotBlank()) {
            val newBook = Book(
                id = nextId++,
                title = currentBookTitle,
                author = currentBookAuthor
            )
            _books.update { currentBooks -> currentBooks + newBook }
            clearForm()
        }
    }

    fun updateBook() {
        val id = currentBookId ?: return
        if (currentBookTitle.isNotBlank() && currentBookAuthor.isNotBlank()) {
            val updatedBook = Book(
                id = id,
                title = currentBookTitle,
                author = currentBookAuthor
            )
            _books.update { currentBooks ->
                currentBooks.map { book ->
                    if (book.id == id) updatedBook else book
                }
            }
            clearForm()
        }
    }

    fun removeBook(book: Book) {
        _books.update { currentBooks -> currentBooks.filterNot { it.id == book.id } }
    }

    fun prepareForEdit(book: Book) {
        currentBookId = book.id
        currentBookTitle = book.title
        currentBookAuthor = book.author
    }

    fun updateTitle(title: String) {
        currentBookTitle = title
    }

    fun updateAuthor(author: String) {
        currentBookAuthor = author
    }

    private fun clearForm() {
        currentBookId = null
        currentBookTitle = ""
        currentBookAuthor = ""
    }
}