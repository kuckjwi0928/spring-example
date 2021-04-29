package kuckjwi.com.example.spring.data.redis.domains.request;

import kuckjwi.com.example.spring.data.redis.domains.HashConvert;
import kuckjwi.com.example.spring.data.redis.domains.hash.RedisHashObject;
import lombok.Data;

import java.util.UUID;

@Data
public class RedisRequest implements HashConvert<RedisHashObject> {
  private String name;

  private int age;

  @Override
  public RedisHashObject convert() {
    return new RedisHashObject(UUID.randomUUID().toString(), name, age);
  }
}
