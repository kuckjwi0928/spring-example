package kuckjwi.com.example.spring.graphql.domain.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "product")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class ProductEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
