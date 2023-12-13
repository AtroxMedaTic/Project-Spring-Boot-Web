package avalon.springframework.services;

import avalon.springframework.model.TodoList;

public interface TodoListService {
  Iterable<TodoList> listAllProducts();

  TodoList getProductById(Integer id);

  TodoList saveProduct(TodoList product);
}
