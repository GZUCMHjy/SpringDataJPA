package com.example.jpa_demo.Repository;

import com.example.jpa_demo.Pojo.Entity.Book;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TestBookRepository3 extends PagingAndSortingRepository<Book,Integer>, QuerydslPredicateExecutor<Book> {
    //(静态/动态)条件查询二 QueryDSL是基于ORM框架或SQL平台上的一个通用查询框架。借助QueryDSL可以在任何支持的ORM框架或SQL平台
    //需要手动将生成的Q文件转化为Source代码资源(不过一次就够了) maven compile一下
    //需要配置依赖和插件(较为麻烦)
    //较与动态查询一 代码更简洁 直接引用Q类的静态资源
}
