package kuckjwi.com.example.spring.ratelimit.controller;

import io.github.bucket4j.Bucket;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bucket4j")
@RestController
@RequiredArgsConstructor
public class Bucket4JController {
  private final Bucket bucket;

  @GetMapping("/hello")
  public ResponseEntity<String> getHello() {
    if (bucket.tryConsume(1)) {
      return ResponseEntity.ok("hello");
    }
    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
  }
}
