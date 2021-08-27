package kuckjwi.com.example.spring.graphql.domain.product;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMutationResolver implements GraphQLMutationResolver {
  private final ProductQueryResolver queryResolver;

  private final ProductRepository repository;

  public long addProduct(ProductRequest request) {
    return repository.save(request.toEntity()).getId();
  }

  public void removeProduct(long id) {
    repository.delete(queryResolver.product(id));
  }
}
