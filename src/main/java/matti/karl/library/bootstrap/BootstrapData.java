package matti.karl.library.bootstrap;

import matti.karl.library.model.Author;
import matti.karl.library.model.Book;
import matti.karl.library.model.Publisher;
import matti.karl.library.repository.AuthorRepository;
import matti.karl.library.repository.BookRepository;
import matti.karl.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {



    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Book book0 = new Book("0", "What to say when you talk to yourself", 4.9);
        //Book book1 = new Book("1", "Pragmatic Programmer", 5.0);
        Book book0 = new Book("How to win friends..", 5.0);
        Author author0 = new Author("Dale", "Carnegie", "24.11.1888");
        author0.getBooks().add(book0);
        book0.getAuthors().add(author0);
        Publisher publisher0 = new Publisher("New York Times0", "Times Square 323-32, New York, NYC, 8885550");

        book0.setPublisher(publisher0);

        System.out.println("Saving... " + authorRepository.save(author0));
        System.out.println("Saving... " + publisherRepository.save(publisher0));
        System.out.println("Saving... " + bookRepository.save(book0));


        Book book1 = new Book("What to say when you talk to yourself", 5.0);
        Author author1 = new Author("Shad", "Helmstetter");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        Publisher publisher1 = new Publisher("New York Times1", "Times Square 323-32, New York, NYC, 8885551");
        book1.setPublisher(publisher1);

        // Order is important. For example: You cannot save book before publisher.

        System.out.println("Saving... " + publisherRepository.save(publisher1));
        System.out.println("Saving... " + authorRepository.save(author1));
        System.out.println("Saving... " + bookRepository.save(book1));



        System.out.println("Added data from Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}
