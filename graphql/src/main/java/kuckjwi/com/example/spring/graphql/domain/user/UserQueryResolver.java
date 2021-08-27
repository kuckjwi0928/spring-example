package kuckjwi.com.example.spring.graphql.domain.user;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@RequiredArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver {
  private final UserRepository repository;

  public UserEntity user(long id) {
    return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
}
