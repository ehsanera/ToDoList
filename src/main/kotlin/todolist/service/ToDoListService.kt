package todolist.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import todolist.document.to
import todolist.dto.ToDoListCreateDto
import todolist.dto.ToDoListDto
import todolist.dto.ToDoListUpdateDto
import todolist.repository.ToDoListRepository

@Service
class ToDoListService @Autowired constructor(
    private val toDoListRepository: ToDoListRepository
) {
    fun get(): List<ToDoListDto>? {
        return toDoListRepository.findAll().map { it.toDto() }
    }

    fun getById(id: String): ToDoListDto? {
        return toDoListRepository.findByIdOrNull(id)?.toDto()
    }

    fun save(t: ToDoListCreateDto): ToDoListDto {
        return toDoListRepository.save(t.to()).toDto()
    }

    fun update(id: String, t: ToDoListUpdateDto): ToDoListDto? {
        val currentDocument = toDoListRepository.findByIdOrNull(id)
        return if (currentDocument == null) {
            null
        } else {
            toDoListRepository.save(t.to(currentDocument)).toDto()
        }
    }

    fun delete(id: String) {
        return toDoListRepository.deleteById(id)
    }
}
