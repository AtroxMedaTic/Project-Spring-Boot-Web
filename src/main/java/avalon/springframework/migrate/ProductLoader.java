package avalon.springframework.migrate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import avalon.springframework.model.TodoList;
import avalon.springframework.repositories.TodoListRepository;

import java.math.BigDecimal;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {

  private TodoListRepository productRepository;

  private Logger log = LogManager.getLogger(ProductLoader.class);

  @Autowired
  public void setProductRepository(TodoListRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {

    TodoList one = new TodoList();
    one.setTodo("Minimal running dlu deh ini");
    productRepository.save(one);
    log.info("Saved todo - id: " + one.getId());

    TodoList two = new TodoList();
    two.setTodo("Lalu buat todo listnya");
    productRepository.save(two);
    log.info("Saved two - id:" + two.getId());
  }
}
