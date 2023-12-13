package avalon.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import avalon.springframework.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
