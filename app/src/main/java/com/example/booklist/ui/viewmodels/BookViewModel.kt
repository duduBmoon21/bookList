import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BookViewModel : ViewModel() {
    private val _books = MutableStateFlow<List<Book>>(emptyList())
    val books = _books.asStateFlow()

    var newBookTitle by mutableStateOf("")
        private set
    var newBookAuthor by mutableStateOf("")
        private set

    fun addBook() {
        if (newBookTitle.isNotBlank() && newBookAuthor.isNotBlank()) {
            val newBook = Book(
                id = _books.value.size + 1,
                title = newBookTitle,
                author = newBookAuthor
            )
            _books.update { currentBooks -> currentBooks + newBook }
            newBookTitle = ""
            newBookAuthor = ""
        }
    }

    fun removeBook(book: Book) {
        _books.update { currentBooks -> currentBooks - book }
    }

    fun updateTitle(title: String) {
        newBookTitle = title
    }

    fun updateAuthor(author: String) {
        newBookAuthor = author
    }
}