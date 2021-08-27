package kuckjwi.com.example.spring.graphql.domain.user;

import kuckjwi.com.example.spring.graphql.infrastructure.converter.EntityConverter;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserRequest implements EntityConverter<UserEntity> {
  String name;

  int age;

  @Override
  public UserEntity toEntity() {
    return new UserEntity(name, age);
  }
}
