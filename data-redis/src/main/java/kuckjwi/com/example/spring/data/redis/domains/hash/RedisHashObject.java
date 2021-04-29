package kuckjwi.com.example.spring.data.redis.domains.hash;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@AllArgsConstructor
@RedisHash("prefix")
@Data
public class RedisHashObject {
  @Id
  private String id;

  private String name;

  private int age;
}
