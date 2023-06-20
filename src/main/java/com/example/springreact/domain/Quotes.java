package com.example.springreact.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Quotes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long quotesId;

    private String textQuotes;


    public Quotes(){}

    public Quotes(String textQuotes, Book book){

        this.textQuotes = textQuotes;
        this.book = book;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book")
    private Book book;






}
