package com.example.jpa_demo.Repository;

import com.example.jpa_demo.Pojo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author LouisBrilliant
 * @version 1.0
 */
//俩参数 实体类 和 ID类型
//Repository数据访问层
public interface TestBookRepository0 extends JpaRepository<Book,Integer> {//如若不写 直接调用jpa框架实现好的crud的API
    //1. JPA命名规范的方法 只能是查询find的方法
    Book findByBookID(Integer id);

    List<Book> findBooksByBookName(String bookName);

    //2. 自定义原生SQL方法即JPQL 无需理会JPA自定义命名规则 注解@Query
    //索引 格式 =?数字
    //具名 格式 =:参数名 结合@Param注解指定参数名
    @Query("FROM Book where bookName=?1")//将对象Book转化成数据表 即表名等于类名
    Book findBookByBookName(String name);

    @Query("update Book b set  b.bookName=:bookName where b.bookID=:bookId")
    //增删改 需要下面两个注解 ！！！
    @Transactional
    @Modifying
    //类型是int或void 修改指定书籍id更改对应书籍的书名
    int updateBookByBookNameAndId(@Param("bookName")String bookName,@Param("bookId")Integer bookId);
    //纯sql 将nativeQuery设置成true value后跟的是sql语句

//    @Query(value = "select * from  book where bookName=:bookName",nativeQuery = true)
//    Book queryBookByName(@Param("bookName") String bookName);

}
