package com.example.jpa_demo.Service;

import com.example.jpa_demo.Repository.TestBookRepository0;
import com.example.jpa_demo.Pojo.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LouisBrilliant
 * @version 1.0
 */
@Service
public class TestBookServiceImpl implements TestBookService {
    @Autowired
    TestBookRepository0 testBookDao;
    //查
    @Override
    public Book findBookById(Integer id) {
        return testBookDao.findByBookID(id);
    }
    //加
    @Override
    public Boolean addBook(Book book){
        testBookDao.save(book);
        return true;
    }
    //删
    @Override
    public Boolean deleteBook(Integer id) {
        testBookDao.deleteById(id);
        return true;

    }
    //改
    @Override
    public Boolean updateBook(Book book) {
        Book book1 = new Book();
        book1.setBookName(book.getBookName());
        book1.setBookID(book.getBookID());
        testBookDao.save(book1);
        return true;
    }
}
