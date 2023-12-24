package avalon.springframework.services;

import avalon.springframework.model.TodoList;

public interface TodoListService {
  Iterable<TodoList> getAllTodoList();

  TodoList getTodoListbyId(Integer id);

  TodoList saveTodoList(TodoList product);

  TodoList deleteTodoList(Integer id);
}
