package com.example.jpa_demo.serviceTest;

import com.example.jpa_demo.Repository.TestBookRepository0;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author LouisBrilliant
 * @version 1.0
 */
@SpringBootTest//要有这个注解
public class ServiceTest {
    @Autowired
    TestBookRepository0 testBookDao;
    @Test
    //对于测试方法的声明有如下要求测试方法名字可以随便取，没有任何限制，但是返回值必须为 void，而且不能有任 何参数。
    public void  findBookById(){
//        System.out.println(testBookDao.findByBookID(1));
        System.out.println(testBookDao.findById(1));
    }
}
