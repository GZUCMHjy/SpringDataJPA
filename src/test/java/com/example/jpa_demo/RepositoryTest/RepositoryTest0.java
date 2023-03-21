package com.example.jpa_demo.RepositoryTest;

import com.example.jpa_demo.Repository.TestBookRepository0;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class RepositoryTest0 {
    @Autowired
    TestBookRepository0 testBookDao;
    @Test
    //自定义规定方法名查询
    public void queryBook(){
        System.out.println(testBookDao.findBookByBookName("神雕侠侣"));
    }
    @Test
    public void updateBook(){
        System.out.println(testBookDao.updateBookByBookNameAndId("白鹿原",2));
    }
    @Test
    public void findAllBookByTheSameName(){
        System.out.println(testBookDao.findBooksByBookName("倚天屠龙记"));
    }

}
