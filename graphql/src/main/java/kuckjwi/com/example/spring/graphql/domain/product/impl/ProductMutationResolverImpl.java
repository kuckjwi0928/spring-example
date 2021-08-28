package kuckjwi.com.example.spring.graphql.domain.product.impl;

import graphql.schema.DataFetchingEnvironment;
import kuckjwi.com.example.spring.graphql.domain.product.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductMutationResolverImpl implements ProductMutationResolver {
  private final ProductQueryResolver queryResolver;

  private final ProductRepository repository;

  @Override
  public ProductEntity addProduct(ProductRequest request, DataFetchingEnvironment environment) {
    return repository.save(request.toEntity());
  }

  @Override
  public void removeProduct(long id) {
    repository.delete(queryResolver.product(id));
  }
}
