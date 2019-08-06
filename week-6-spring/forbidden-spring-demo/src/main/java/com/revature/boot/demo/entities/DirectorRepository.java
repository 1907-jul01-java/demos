package com.revature.boot.demo.entities;

import com.revature.boot.demo.domain.Director;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "directors", path = "directors")
public interface DirectorRepository extends PagingAndSortingRepository<Director, Integer> {

}