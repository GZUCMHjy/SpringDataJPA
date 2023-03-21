package com.example.jpa_demo.Service;

import com.example.jpa_demo.Pojo.Entity.Book;

/**
 * @author LouisBrilliant
 * @version 1.0
 */
//业务逻辑层
public interface TestBookService {
    //根据id查找书籍
    public Book findBookById(Integer id);
    //添加书籍
    public Boolean addBook(Book book);
    //删除书籍
    public Boolean deleteBook(Integer id);
    //更新书籍
    public Boolean updateBook(Book book);
}
