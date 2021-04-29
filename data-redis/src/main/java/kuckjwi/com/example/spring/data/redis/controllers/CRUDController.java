package kuckjwi.com.example.spring.data.redis.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDController<P, R, ID> {
  ResponseEntity<R> get(ID id);

  ResponseEntity<List<R>> getAll();

  ResponseEntity<Void> add(P p);

  ResponseEntity<Void> delete(ID id);

  ResponseEntity<R> set(ID id, P p);
}
