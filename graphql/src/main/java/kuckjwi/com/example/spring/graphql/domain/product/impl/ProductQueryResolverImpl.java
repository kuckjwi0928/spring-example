package kuckjwi.com.example.spring.graphql.domain.product.impl;

import kuckjwi.com.example.spring.graphql.domain.product.ProductEntity;
import kuckjwi.com.example.spring.graphql.domain.product.ProductQueryResolver;
import kuckjwi.com.example.spring.graphql.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductQueryResolverImpl implements ProductQueryResolver {
  private final ProductRepository repository;

  @Override
  public ProductEntity product(long id) {
    return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }

  @Override
  public List<ProductEntity> products(int page, int limit) {
    return repository.findAll(PageRequest.of(page - 1, limit)).toList();
  }
}
