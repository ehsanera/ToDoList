package todolist.dto

data class ToDoListUpdateDto(
    val title: String? = null,
    val checked: Boolean? = null
)
