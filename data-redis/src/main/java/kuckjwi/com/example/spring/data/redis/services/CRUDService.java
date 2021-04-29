package kuckjwi.com.example.spring.data.redis.services;

import java.util.List;

public interface CRUDService<P, R, ID> {
  R add(P p);

  R set(ID id, P p);

  void delete(ID id);

  R get(ID id);

  List<R> getAll();
}
