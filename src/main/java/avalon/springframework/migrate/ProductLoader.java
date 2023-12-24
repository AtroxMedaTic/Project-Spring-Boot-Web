package avalon.springframework.migrate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import avalon.springframework.model.TodoList;
import avalon.springframework.repositories.TodoListRepository;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

  private TodoListRepository todoListRepository;

  private Logger log = LogManager.getLogger(ProductLoader.class);

  @Autowired
  public void setProductRepository(TodoListRepository productRepository) {
    this.todoListRepository = productRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    TodoList one = new TodoList();
    one.setTodo("Kerjakan tugas pbo");
    todoListRepository.save(one);
    log.info("Saved todo - id: " + one.getId());

    TodoList two = new TodoList();
    two.setTodo("Prensentasi pbo");
    todoListRepository.save(two);
    log.info("Saved todo - id:" + two.getId());

    TodoList three = new TodoList();
    three.setTodo("hapus bagian ini jika sudah selesai prensentasi");
    todoListRepository.save(three);
    log.info("Saved todo - id:" + three.getId());
  }
}
