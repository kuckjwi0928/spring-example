package kuckjwi.com.example.spring.data.redis.services;

import kuckjwi.com.example.spring.data.redis.domains.hash.RedisHashObject;
import kuckjwi.com.example.spring.data.redis.domains.request.RedisRequest;
import kuckjwi.com.example.spring.data.redis.repositories.RedisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class RedisCRUDService implements CRUDService<RedisRequest, RedisHashObject, String> {
  private final RedisRepository repository;

  @Override
  public RedisHashObject add(RedisRequest request) {
    return repository.save(request.convert());
  }

  @Override
  public RedisHashObject set(String id, RedisRequest request) {
    RedisHashObject hashObject = get(id);
    hashObject.setName(request.getName());
    hashObject.setAge(request.getAge());
    return repository.save(hashObject);
  }

  @Override
  public void delete(String id) {
    repository.delete(get(id));
  }

  @Override
  public RedisHashObject get(String id) {
    return repository.findById(id).orElseThrow(() -> {throw new ResponseStatusException(HttpStatus.NOT_FOUND);});
  }

  @Override
  public List<RedisHashObject> getAll() {
    List<RedisHashObject> list = StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
    if (list.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return list;
  }
}
