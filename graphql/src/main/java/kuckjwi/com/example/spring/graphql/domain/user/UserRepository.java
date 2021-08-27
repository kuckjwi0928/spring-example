package kuckjwi.com.example.spring.graphql.domain.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
