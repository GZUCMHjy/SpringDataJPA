package com.example.jpa_demo.Repository;

import com.example.jpa_demo.Pojo.Entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TestBookRepository1 extends PagingAndSortingRepository<Book,Integer> {
    //继承分页Repository的接口方法 findAll()
}
