package com.example.springreact;

import com.example.springreact.domain.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
public class SpringReactApplication implements CommandLineRunner {
    private static final Logger logger =  LoggerFactory.getLogger(SpringReactApplication.class);
    @Autowired
    private BookRepository repository;
    @Autowired
    private QuotesRepository quotesRepository;


    public static void main(String[] args) {

        SpringApplication.run(SpringReactApplication.class, args);

        logger.info("App started");
    }

    @Override
    public void run(String... args) throws Exception{
       Book book1 = new Book("Book1", "Author1", 2023);
       Book book2 = new Book("Book2", "Author2", 2022);
       Book book3 = new Book("Book45", "NoName", 2345);
       repository.save(book1);
       repository.save(book2);
       repository.save(book3);
       Quotes quotes1 = new Quotes("La ala la la ", book1);
       Quotes quotes2 = new Quotes("Bla bla bla bla ...", book3);
       quotesRepository.saveAll(Arrays.asList(quotes1, quotes2));


        for (Book book: repository.findAll()
        ) {
            logger.info(book.getName() + " " + book.getAuthor());

        }


    }

}
