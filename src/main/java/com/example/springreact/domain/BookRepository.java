package com.example.springreact.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "books") - переименовывает ссылку на данную таблицу
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query("select  b from Book b where b.name = ?1")
    List<Book> findBookByName(String name);


    List<Book> findBookByAuthor(@Param("author") String author);

    List<Book> findBookByYear(int year);

    List<Book> findBookByNameAndAuthor(String name, String author);


    List<Book> findBookByNameOrderByYear(String name);

    @Query("select b from Book b where b.name like %?1")
    List<Book> findBookByNameStartsWith(String name);





}
