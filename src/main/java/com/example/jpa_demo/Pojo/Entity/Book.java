package com.example.jpa_demo.Pojo.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author LouisBrilliant
 * @version 1.0
 */
@Entity//spring_data_jpa注解
@Data //lombok的注解
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookID;
    private String bookName;
}
