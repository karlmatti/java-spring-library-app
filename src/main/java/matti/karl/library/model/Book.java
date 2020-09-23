package matti.karl.library.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private double rating;

    @ManyToMany
    @JoinTable(name="author_book", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToOne
    private Publisher publisher;

    public Book(Long id, String title, double rating, Set<Author> authors) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.authors = authors;
    }

    public Book(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String authorsString = authors.stream().map(Author::getLastName).collect(Collectors.joining(","));
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", authors=" + authorsString +
                ", publisher=" + publisher.getName() +
                '}';
    }
}
