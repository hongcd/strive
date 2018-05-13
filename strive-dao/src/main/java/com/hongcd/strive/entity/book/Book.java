package com.hongcd.strive.entity.book;

import com.hongcd.strive.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_book")
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity {
    @Column(length = 64, nullable = false)
    private String name;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String author;
    @Column(name = "publish_time")
    private Date publishTime;
}