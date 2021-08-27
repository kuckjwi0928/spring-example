package kuckjwi.com.example.spring.graphql.domain.product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
