package com.example.jpa_demo.RepositoryTest;

import com.example.jpa_demo.Pojo.Entity.Book;
import com.example.jpa_demo.Pojo.Entity.QBook;
import com.example.jpa_demo.Repository.TestBookRepository4;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RepositoryTest4 {
    @Autowired
    TestBookRepository4 testBookRepository4;

    @Test
    void test04(){
        Book book = new Book();
        book.setBookName("降龙十八掌");
        System.out.println(testBookRepository4.findAll(new Specification<Book>() {// 匿名内部类 函数接口！(就涉及到了类Predicate)
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                //root from Book(实体类对象表) 1.通过root动态获取持久化对象表中的列 (获取字段)
                Path<Integer> bookID = root.get("bookID");//泛型类型改成对应对象的属性类型
                Path<String> bookName = root.get("bookName");
                // CriteriaBuilder where 2.通过CriteriaBuilder设置各种条件 (大于小于 in) 多种类型进行大小比较
                //参数一 为哪个字段设置条件 参数二 value值类型是Object
                //动态查询 逻辑判断查询 原生sql语句
                //使用list集合存储Predicate（条件）类型
                List<Predicate> list = new ArrayList<>();//使用lambda表达式
                if (book.getBookName() != null) {
                    //若数据库中有“倚天屠龙记”就记录到list集合当中
                    list.add(cb.equal(bookName, "倚天屠龙记"));//符合添加到泛型为Predicate(函数式编程接口) 降龙十八掌可以是前端传过来的值！因为做测试 就不专门实例化一个对象了
                }

                Predicate and = cb.and(list.toArray(new Predicate[list.size()]));//转换成数组toArray new一个Predicate数组 因为需要的参数是一个可变的数组Predicate...arr 低沉实现就是一个数组
                //非动态查询(无判断进行筛选)
                //Predicate bookNameP = cb.equal(bookName, "倚天屠龙记");简化lambda表达式 用Predicate类型接收lambda表达式
                //Predicate bookIdP = cb.greaterThan(bookID,0);
                //Predicate and = cb.and(bookIdP, bookNameP);多条件（n个）合并&&
                //query 组合多条件（order by,where)

                Order desc = cb.desc(bookName);
                return query.
                        where(and).
                        orderBy(desc).
                        getRestriction();
            }
        }));

    }
    @Test
    void test05(){
        testBookRepository4.findOne(new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path<Integer> bookID = root.get("bookID");//获取字段
                return criteriaBuilder.equal(bookID,1);
            }
        });
    }


}
