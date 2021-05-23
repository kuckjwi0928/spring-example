package kuckjwi.com.example.spring.mapstruct;

import kuckjwi.com.example.spring.mapstruct.entity.JobEntity;
import kuckjwi.com.example.spring.mapstruct.entity.PersonEntity;
import kuckjwi.com.example.spring.mapstruct.mapper.PersonMapper;
import kuckjwi.com.example.spring.mapstruct.mapper.PersonMapperImpl;
import kuckjwi.com.example.spring.mapstruct.model.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MapstructTests {
  private final PersonMapper personMapper = new PersonMapperImpl();

  @Test
  void mapperTest() {
    PersonEntity entity = new PersonEntity();

    entity.setId(1);
    entity.setAge(30);
    entity.setName("kuckjwi");

    Person person = personMapper.of(entity);

    assertEquals(person.getAge(), entity.getAge());
    assertEquals(person.getName(), entity.getName());
  }

  @Test
  void mapperTest2() {
    PersonEntity entity = new PersonEntity();
    entity.setId(1);
    entity.setAge(30);
    entity.setName("kuckjwi");

    JobEntity jobEntity = new JobEntity();
    jobEntity.setId(1);
    jobEntity.setName("developer");
    jobEntity.setCareer(6);

    Person person = personMapper.of(entity);

    assertEquals(person.getAge(), entity.getAge());
    assertEquals(person.getName(), entity.getName());
    assertEquals(person.getJob().getName(), jobEntity.getName());
    assertEquals(person.getJob().getCareer(), jobEntity.getCareer());
  }
}
