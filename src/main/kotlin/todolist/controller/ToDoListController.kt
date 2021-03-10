package todolist.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import todolist.annotation.ApiMapping
import todolist.dto.ToDoListCreateDto
import todolist.dto.ToDoListDto
import todolist.dto.ToDoListUpdateDto
import todolist.service.ToDoListService

@ApiMapping
class ToDoListController @Autowired constructor(
    private val toDoListService: ToDoListService
) {
    @PostMapping("todolist")
    fun post(@RequestBody create: ToDoListCreateDto): ResponseEntity<ToDoListDto> {
        return ResponseEntity(toDoListService.save(create), HttpStatus.CREATED)
    }

    @GetMapping("todolist")
    fun get(): ResponseEntity<List<ToDoListDto>?> {
        return ResponseEntity(toDoListService.get(), HttpStatus.OK)
    }

    @GetMapping("todolist/{id}")
    fun getById(@PathVariable id: String): ResponseEntity<ToDoListDto?> {
        return ResponseEntity(toDoListService.getById(id), HttpStatus.OK)
    }

    @PutMapping("todolist/{id}")
    fun put(@PathVariable id: String, @RequestBody update: ToDoListUpdateDto): ResponseEntity<ToDoListDto?> {
        return ResponseEntity(toDoListService.update(id, update), HttpStatus.CREATED)
    }

    @DeleteMapping("todolist/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Unit> {
        return ResponseEntity(toDoListService.delete(id), HttpStatus.OK)
    }
}