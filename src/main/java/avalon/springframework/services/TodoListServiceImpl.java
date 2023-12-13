package avalon.springframework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import avalon.springframework.model.TodoList;
import avalon.springframework.repositories.TodoListRepository;

@Service
public class TodoListServiceImpl implements TodoListService {
  private TodoListRepository productRepository;

  @Autowired
  public void setProductRepository(TodoListRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Iterable<TodoList> listAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public TodoList getProductById(Integer id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  public TodoList saveProduct(TodoList product) {
    return productRepository.save(product);
  }
}
