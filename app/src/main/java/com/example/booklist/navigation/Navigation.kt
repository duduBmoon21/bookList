sealed class Screen(val route: String) {
    object BookList : Screen("bookList")
    object AddBook : Screen("addBook")
}