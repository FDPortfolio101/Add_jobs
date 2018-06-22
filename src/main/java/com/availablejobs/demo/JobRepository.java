package com.availablejobs.demo;
import org.springframework.data.repository.CrudRepository;


public interface JobRepository extends CrudRepository<Jobs, Long> {

}