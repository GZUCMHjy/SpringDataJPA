package com.example.jpa_demo.RepositoryTest;

import com.example.jpa_demo.Pojo.Entity.Book;
import com.example.jpa_demo.Repository.TestBookRepository1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class RepositoryTest1 {
    @Autowired
    TestBookRepository1 testBookRepository1;
    @Test
    public void findAll(){
        System.out.println(testBookRepository1.findAll(PageRequest.of(0,2)));//从第一条开始 每页内容只有两条
        Page<Book> all = testBookRepository1.findAll(PageRequest.of(0, 2));
        System.out.println(all.getTotalElements());//求元素个数
        System.out.println(all.getTotalPages());//求总页数
        System.out.println(all.getContent());//求所有具体信息
    }
}
