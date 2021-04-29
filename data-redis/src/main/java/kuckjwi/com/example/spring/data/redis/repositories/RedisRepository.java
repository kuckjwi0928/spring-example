package kuckjwi.com.example.spring.data.redis.repositories;

import kuckjwi.com.example.spring.data.redis.domains.hash.RedisHashObject;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<RedisHashObject, String> {
}
