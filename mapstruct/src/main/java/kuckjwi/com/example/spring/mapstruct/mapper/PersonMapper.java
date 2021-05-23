package kuckjwi.com.example.spring.mapstruct.mapper;

import kuckjwi.com.example.spring.mapstruct.entity.JobEntity;
import kuckjwi.com.example.spring.mapstruct.entity.PersonEntity;
import kuckjwi.com.example.spring.mapstruct.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = JobMapper.class)
public interface PersonMapper {
  @Mapping(target = "job", ignore = true)
  Person of(PersonEntity entity);

  @Mappings({
    @Mapping(source = "entity.name", target = "name"),
    @Mapping(source = "jobEntity", target = "job")
  })
  Person of(PersonEntity entity, JobEntity jobEntity);
}
