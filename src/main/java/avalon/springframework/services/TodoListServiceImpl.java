package avalon.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avalon.springframework.model.TodoList;
import avalon.springframework.repositories.TodoListRepository;

@Service
public class TodoListServiceImpl implements TodoListService {
  private TodoListRepository todoListRepository;

  @Autowired
  public void setProductRepository(TodoListRepository todoListRepository) {
    this.todoListRepository = todoListRepository;
  }

  @Override
  public Iterable<TodoList> getAllTodoList() {
    return todoListRepository.findAll();
  }

  @Override
  public TodoList getTodoListbyId(Integer id) {
    return todoListRepository.findById(id).orElse(null);
  }

  @Override
  public TodoList saveTodoList(TodoList product) {
    return todoListRepository.save(product);
  }

  @Override
  public TodoList deleteTodoList(Integer id) {
    TodoList todoList = todoListRepository.findById(id).orElse(null);
    todoListRepository.deleteById(id);
    return todoList;
  }
}
