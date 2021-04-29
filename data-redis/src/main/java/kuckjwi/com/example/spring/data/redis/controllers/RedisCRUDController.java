package kuckjwi.com.example.spring.data.redis.controllers;

import kuckjwi.com.example.spring.data.redis.domains.hash.RedisHashObject;
import kuckjwi.com.example.spring.data.redis.domains.request.RedisRequest;
import kuckjwi.com.example.spring.data.redis.services.RedisCRUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisCRUDController implements CRUDController<RedisRequest, RedisHashObject, String> {
  private final RedisCRUDService redisCRUDService;

  @Override
  @GetMapping("{id}")
  public ResponseEntity<RedisHashObject> get(@PathVariable("id") String id) {
    return ResponseEntity.ok(redisCRUDService.get(id));
  }

  @GetMapping
  @Override
  public ResponseEntity<List<RedisHashObject>> getAll() {
    return ResponseEntity.ok(redisCRUDService.getAll());
  }

  @PostMapping
  @Override
  public ResponseEntity<Void> add(@RequestBody RedisRequest request) {
    RedisHashObject hashObject = redisCRUDService.add(request);
    return ResponseEntity.created(URI.create("/redis/" + hashObject.getId())).build();
  }

  @PutMapping("{id}")
  @Override
  public ResponseEntity<RedisHashObject> set(@PathVariable("id") String id, @RequestBody RedisRequest request) {
    return ResponseEntity.ok(redisCRUDService.set(id, request));
  }

  @DeleteMapping("{id}")
  @Override
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    redisCRUDService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
