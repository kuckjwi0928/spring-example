package kuckjwi.com.example.spring.graphql.domain.product;

import kuckjwi.com.example.spring.graphql.infrastructure.converter.EntityConverter;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductRequest implements EntityConverter<ProductEntity> {
  String name;

  int quantity;

  int price;

  @Override
  public ProductEntity toEntity() {
    return new ProductEntity(name, quantity, price);
  }
}
