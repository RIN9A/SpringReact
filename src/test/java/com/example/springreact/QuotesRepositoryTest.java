package com.example.springreact;


import com.example.springreact.domain.Book;
import com.example.springreact.domain.Quotes;
import com.example.springreact.domain.QuotesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class QuotesRepositoryTest {
    @Autowired
    private QuotesRepository repository;

    @Test
    void saveQuotes(){
        repository.save(new Quotes("Something...", new Book("Book 45", "Author45", 2020)));
        assertThat(repository.findByTextQuotesStartsWith("Something").isPresent()).isTrue();
    }

    @Test
    void deleteQuotes(){

        repository.save(new Quotes("To to to ....", new Book("Book 33","Author 33", 2018)));
        repository.deleteAll();
        assertThat(repository.count()).isEqualTo(0);
    }


}
