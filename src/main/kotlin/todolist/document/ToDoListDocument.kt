package todolist.document

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import todolist.dto.ToDoListCreateDto
import todolist.dto.ToDoListDto
import todolist.dto.ToDoListUpdateDto

@Document("ToDoLists")
class ToDoListDocument(
    @Id
    var id: String?,
    val title: String,
    val checked: Boolean
) {
    fun toDto() = ToDoListDto(
        id!!,
        title,
        checked
    )
}

fun ToDoListCreateDto.to() = ToDoListDocument(
    null,
    title,
    checked
)

fun ToDoListUpdateDto.to(current: ToDoListDocument) = ToDoListDocument(
    current.id,
    title ?: current.title,
    checked ?: current.checked,
)