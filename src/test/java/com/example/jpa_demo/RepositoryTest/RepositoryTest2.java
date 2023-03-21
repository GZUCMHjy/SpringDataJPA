package com.example.jpa_demo.RepositoryTest;

import com.example.jpa_demo.Pojo.Entity.Book;
import com.example.jpa_demo.Repository.TestBookRepository2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

@SpringBootTest
public class RepositoryTest2 {
    @Autowired
    TestBookRepository2 testBookRepository2;//继承了QueryByExampleExecutor(查询对象加匹配器(内嵌筛选条件))
    @Test
    void findUDomesticBook(){//静态查询
        Book book = new Book();
        book.setBookName("屠龙记");//1.这都可以是前端传过来的数据 这里直接创一个
        //2.通过匹配器 对条件进行自定义设置（可以不写）
        ExampleMatcher matching = ExampleMatcher.matching()
                .withIgnorePaths("bookName")//设置忽略属性
                .withIgnoreCase("bookName")//设置忽略大小写 要对应该类的属性名(要保持一致)
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING)//对所有条件字符串进行结尾匹配(模糊查询)
                .withMatcher("bookName",m-> m.endsWith());//针对单个条件进行锁定查询(模糊查询)
        //3.通过Example整合查询条件和持久化对象表
        Example<Book> example=Example.of(book,matching);//俩参数 类对象Object和匹配器ExampleMatcher
        //4.强制类型转换
        List<Book> list=(List<Book>)testBookRepository2.findAll(example);
        System.out.println(list);
    }
}
