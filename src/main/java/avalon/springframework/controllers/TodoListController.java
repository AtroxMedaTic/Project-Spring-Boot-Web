package avalon.springframework.controllers;

import avalon.springframework.model.TodoList;
import avalon.springframework.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoListController {

  private TodoListService todoListService;

  @Autowired
  public void setProductService(TodoListService todoListService) {
    this.todoListService = todoListService;
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("todos", todoListService.getAllTodoList());
    model.addAttribute("todoRequest", new TodoList());
    System.out.println("Returning todo:");
    return "todolist";
  }

  @RequestMapping(value = "list", method = RequestMethod.POST)
  public String saveProduct(TodoList todo) {

    todoListService.saveTodoList(todo);
    System.out.println("Returning todo :" + todo.getTodo());

    return "redirect:/list";
  }

  // create for delete method
  @RequestMapping(value = "/list/delete", method = RequestMethod.POST)
  public String delete(@RequestParam("id") Integer id) {
    System.out.println("Deleting todo list with id: " + id);
    todoListService.deleteTodoList(id);
    return "redirect:/list";
  }

}
