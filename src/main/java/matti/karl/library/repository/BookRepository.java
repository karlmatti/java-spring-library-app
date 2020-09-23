package matti.karl.library.repository;

import matti.karl.library.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
