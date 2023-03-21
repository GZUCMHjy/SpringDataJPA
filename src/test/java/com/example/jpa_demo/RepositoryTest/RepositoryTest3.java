package com.example.jpa_demo.RepositoryTest;

import com.example.jpa_demo.Pojo.Entity.Book;
import com.example.jpa_demo.Pojo.Entity.QBook;
import com.example.jpa_demo.Repository.TestBookRepository3;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
public class RepositoryTest3 {
    @Autowired
    TestBookRepository3 testBookRepository3;//继承QuerydslPredicateExecutor接口 (该接口为Qdsl通用查询框架)
    @PersistenceContext
    EntityManager em;
    @Test
    public void test01(){
        QBook book = QBook.book;//以静态方式引用形式进行实例化Q类
        //通过id查找 静态查询
        //eq 相等 in 加多个参数(String类型)and连接多个条件
        //查询单个进行多条件查询 id和bookName
        BooleanExpression eq = book.bookID.eq(1).and(book.bookName.in("天龙八部","仙剑奇侠传","天外飞仙"));
        System.out.println(testBookRepository3.findOne(eq));//参数类型是Predicate 而BooleanExpression是Predicate的子类
    }
    @Test
    public void test02(){
        //动态查询querydsl
        //同样需要对传过来的对象数据进行逻辑判断 然后进行查询
        Book book1 = new Book();//相当于前端传来的数据 这里做测试直接实例一个对象
        book1.setBookName("平凡的世界");
        QBook book = QBook.book;//从数据库获取持久化数据对象(Q类)
        //初始化Qdsl的查询条件
        BooleanExpression exp = book.isNotNull().or(book.isNull());
        exp=book1.getBookID()>-1?exp.and(book.bookID.gt(book1.getBookID())):exp;//前端传来的book1与后端获取的持久化数据进行比较
    }

    @Test
    void test03(){
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(em);//基于接口Querydsl动态查询(推荐)
        //面向querydsl的api编程
        QBook book = QBook.book;//持久化对象表
        //类似原生的sql语句查询 简洁易读易上手 动态改变Repository中的表 原生语句是不基于Repository
        JPAQuery<Tuple> limit = jpaQueryFactory
                .select(book.bookID, book.bookName)//自定义查询Q类中某一属性 如id和name 如果可以通过select判断返回的类型泛型类型就可以确定 如若不能则Tuple或者？
                .from(book)
                .where()
                .orderBy(book.bookID.desc())//降序
                .limit(4);//故返回一个tuple类型的数组
        List<Tuple> fetch = limit.fetch();//转换成一个list数组
        for (Tuple tuple : fetch) {
            System.out.println(tuple.get(book.bookID));
            System.out.println(tuple.get(book.bookName));
        }

    }
}
