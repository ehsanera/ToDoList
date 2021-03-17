package todolist.dto

data class ToDoListCreateDto(
    val title: String,
    val checked: Boolean,
    val ownerId: Int
)
