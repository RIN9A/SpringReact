package com.example.springreact.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;


@RepositoryRestResource
public interface QuotesRepository extends CrudRepository<Quotes, Long> {
    Optional<Quotes> findByTextQuotesStartsWith(String string);

    Optional<Quotes> findByBookName(String name);

}
