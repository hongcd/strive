package com.hongcd.strive.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private String id;
    private String name;
    private Double price;
    private String author;
    private Date publishTime;
}