package kuckjwi.com.example.spring.mapstruct.mapper;

import kuckjwi.com.example.spring.mapstruct.entity.JobEntity;
import kuckjwi.com.example.spring.mapstruct.entity.PersonEntity;
import kuckjwi.com.example.spring.mapstruct.model.Job;
import kuckjwi.com.example.spring.mapstruct.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface JobMapper {
  Job of(JobEntity entity);
}
