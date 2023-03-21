package com.example.jpa_demo.Repository;

import com.example.jpa_demo.Pojo.Entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface TestBookRepository2 extends PagingAndSortingRepository<Book,Integer> , QueryByExampleExecutor<Book> {
    //为实现（动态）查询一(较为冗长) 继承QueryByExampleExecutor接口
    //只能精确(大声)匹配字符串 可以字符串的模糊匹配 不能进行比大小
}
