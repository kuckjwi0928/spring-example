package kuckjwi.com.example.spring.graphql.domain.product;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<ProductEntity, Long> {
}
