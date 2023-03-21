package com.example.jpa_demo.Repository;

import com.example.jpa_demo.Pojo.Entity.Book;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TestBookRepository4 extends PagingAndSortingRepository<Book,Integer>, JpaSpecificationExecutor<Book> {
//Specifications 代码冗长 有点烦
//对于query for example(QueryByExampleExecutor接口) 只能针对字符串模糊查询起作用 而Specification可以任意类型都可以进行查询
}
