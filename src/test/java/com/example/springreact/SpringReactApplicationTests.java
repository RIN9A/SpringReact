package com.example.springreact;

import com.example.springreact.web.BookController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringReactApplicationTests {

    @Autowired
    private BookController controller;



    @Test
    @DisplayName("First example test case")
    void contextLoads() {
        assertThat(controller).isNull();
    }


}
