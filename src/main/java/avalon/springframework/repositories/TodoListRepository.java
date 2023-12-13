package avalon.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import avalon.springframework.model.TodoList;

public interface TodoListRepository extends CrudRepository<TodoList, Integer> {
}
