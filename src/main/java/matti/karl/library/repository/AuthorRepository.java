package matti.karl.library.repository;

import matti.karl.library.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface AuthorRepository extends CrudRepository<Author, Long> {
}
