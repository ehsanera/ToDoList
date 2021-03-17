package todolist.dto

data class ToDoListDto(
    val id: String,
    val title: String,
    val checked: Boolean,
    val ownerId: Int
)
