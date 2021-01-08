package com.majd.springWebApp.bootstrap;

import com.majd.springWebApp.domain.Author;
import com.majd.springWebApp.domain.Book;
import com.majd.springWebApp.domain.Publisher;
import com.majd.springWebApp.repositories.AuthorRepository;
import com.majd.springWebApp.repositories.BookRepository;
import com.majd.springWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("penguin","shekon","muawiya","basma","3002300");
        Author khalid = new Author("khalid","husseini");
        Book mountainsEchoed = new Book("And the mountains echoed","123AAA");
        khalid.getBooks().add(mountainsEchoed);
        mountainsEchoed.getAuthors().add(khalid);

        mountainsEchoed.setPublisher(publisher);
        publisher.getBooks().add(mountainsEchoed);

        authorRepository.save(khalid);
        bookRepository.save(mountainsEchoed);
        publisherRepository.save(publisher);

        System.out.println("Started in bootstrap");
        System.out.println("Number of Books : " + bookRepository.count());


        System.out.println("number of publisher saved: " + publisherRepository.count());

    }
}
