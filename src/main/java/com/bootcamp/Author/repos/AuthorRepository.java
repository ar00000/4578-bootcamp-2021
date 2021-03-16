package com.bootcamp.Author.repos;

import com.bootcamp.Author.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
