package kuckjwi.com.example.spring.graphql.domain.user;

import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMutationResolver implements GraphQLMutationResolver {
  private final UserQueryResolver queryResolver;
  private final UserRepository repository;

  public long addUser(UserRequest request) {
    return repository.save(request.toEntity()).getId();
  }

  public void removeUser(long id) {
    repository.delete(queryResolver.user(id));
  }
}
