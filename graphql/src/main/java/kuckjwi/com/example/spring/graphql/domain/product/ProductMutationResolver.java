package kuckjwi.com.example.spring.graphql.domain.product;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.schema.DataFetchingEnvironment;

public interface ProductMutationResolver extends GraphQLMutationResolver {
  ProductEntity addProduct(ProductRequest request, DataFetchingEnvironment environment);

  void removeProduct(long id);
}
