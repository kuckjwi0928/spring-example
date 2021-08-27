package kuckjwi.com.example.spring.graphql.domain.product;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMutationResolver implements GraphQLMutationResolver {
  private final ProductQueryResolver queryResolver;

  private final ProductRepository repository;

  public long add(ProductRequest request) {
    return repository.save(request.toEntity()).getId();
  }

  public void remove(long id) {
    repository.delete(queryResolver.product(id));
  }
}
