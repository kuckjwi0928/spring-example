package kuckjwi.com.example.spring.mapstruct.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class Job {
  private final String name;

  private final int career;
}
