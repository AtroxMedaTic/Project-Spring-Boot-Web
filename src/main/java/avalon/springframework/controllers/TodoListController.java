package avalon.springframework.controllers;

import avalon.springframework.model.TodoList;
import avalon.springframework.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TodoListController {

  private TodoListService todoListService;

  @Autowired
  public void setProductService(TodoListService todoListService) {
    this.todoListService = todoListService;
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("todos", todoListService.listAllProducts());
    model.addAttribute("todoRequest", new TodoList());
    System.out.println("Returning todo:");
    return "todolist";
  }

  @RequestMapping("product/{id}")
  public String showProduct(@PathVariable Integer id, Model model) {
    model.addAttribute("product", todoListService.getProductById(id));
    return "productshow";
  }

  @RequestMapping("product/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    model.addAttribute("product", todoListService.getProductById(id));
    return "productform";
  }

  @RequestMapping("product/new")
  public String newProduct(Model model) {
    model.addAttribute("product", new TodoList());
    return "productform";
  }

  @RequestMapping(value = "list", method = RequestMethod.POST)
  public String saveProduct(TodoList product) {

    todoListService.saveProduct(product);
    System.out.println("Returning todo :" + product.getTodo());

    return "redirect:/list";
  }

}
