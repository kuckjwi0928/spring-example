package kuckjwi.com.example.spring.graphql.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "user")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  private int age;

  public UserEntity(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
