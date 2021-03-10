package todolist.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import todolist.document.ToDoListDocument

@Repository
interface ToDoListRepository : MongoRepository<ToDoListDocument, String>
