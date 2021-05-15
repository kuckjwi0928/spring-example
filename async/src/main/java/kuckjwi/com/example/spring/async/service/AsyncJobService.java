package kuckjwi.com.example.spring.async.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class AsyncJobService {
  @Async
  public CompletableFuture<Integer> completableFuture() {
    log.info("{}", Thread.currentThread().getName());
    return CompletableFuture.completedFuture(IntStream.range(1, 10000).sum())
            // same thread
            .thenApply(sum -> {
              log.info("{}", Thread.currentThread().getName());
              return sum * 2;
            })
            .thenApply(sum -> {
              log.info("{}", Thread.currentThread().getName());
              return sum / 2;
            })
            // different thread
            .thenApplyAsync(sum -> {
              log.info("{}", Thread.currentThread().getName());
              return sum * 2;
            })
            .thenApplyAsync(sum -> {
              log.info("{}", Thread.currentThread().getName());
              return sum / 2;
            });
  }

  @Async
  public void run() throws InterruptedException {
    log.info("{}", Thread.currentThread().getName());
    Thread.sleep(1000);
    log.info("Started Job");
    log.info("{}", IntStream.range(1, 10000).sum());
    log.info("Ended Job");
  }
}
