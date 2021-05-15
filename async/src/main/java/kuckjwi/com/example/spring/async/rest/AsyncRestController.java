package kuckjwi.com.example.spring.async.rest;

import kuckjwi.com.example.spring.async.service.AsyncJobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/async")
@RequiredArgsConstructor
public class AsyncRestController {
  private final AsyncJobService asyncJobService;

  @GetMapping
  public Integer run() throws InterruptedException {
    asyncJobService.run();
    return Integer.MIN_VALUE;
  }

  @GetMapping("/completable")
  public CompletableFuture<Integer> runComplete() {
    return asyncJobService.completableFuture();
  }
}
