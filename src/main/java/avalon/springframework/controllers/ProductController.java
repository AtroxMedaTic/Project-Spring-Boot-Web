package avalon.springframework.controllers;

import avalon.springframework.domain.Product;
import avalon.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

  private ProductService productService;

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model) {
    model.addAttribute("todos", productService.listAllProducts());
    model.addAttribute("todoRequest", new Product());
    System.out.println("Returning todo:");
    return "todolist";
  }

  @RequestMapping("product/{id}")
  public String showProduct(@PathVariable Integer id, Model model) {
    model.addAttribute("product", productService.getProductById(id));
    return "productshow";
  }

  @RequestMapping("product/edit/{id}")
  public String edit(@PathVariable Integer id, Model model) {
    model.addAttribute("product", productService.getProductById(id));
    return "productform";
  }

  @RequestMapping("product/new")
  public String newProduct(Model model) {
    model.addAttribute("product", new Product());
    return "productform";
  }

  @RequestMapping(value = "list", method = RequestMethod.POST)
  public String saveProduct(Product product) {

    productService.saveProduct(product);
    System.out.println("Returning todo :" + product.getTodo());

    return "redirect:/list";
  }

}
