package kuckjwi.com.example.spring.graphql.domain.product;

import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public interface ProductQueryResolver extends GraphQLQueryResolver {
  ProductEntity product(long id);

  List<ProductEntity> products(int page, int limit);
}
