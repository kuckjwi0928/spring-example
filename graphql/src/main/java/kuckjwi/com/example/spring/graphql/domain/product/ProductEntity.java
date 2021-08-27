package kuckjwi.com.example.spring.graphql.domain.product;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;

  private int quantity;

  private int price;

  public ProductEntity(String name, int quantity, int price) {
    this.name = name;
    this.quantity = quantity;
    this.price = price;
  }
}
