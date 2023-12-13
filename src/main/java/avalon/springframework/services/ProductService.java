package avalon.springframework.services;

import avalon.springframework.domain.Product;

public interface ProductService {
  Iterable<Product> listAllProducts();

  Product getProductById(Integer id);

  Product saveProduct(Product product);
}
