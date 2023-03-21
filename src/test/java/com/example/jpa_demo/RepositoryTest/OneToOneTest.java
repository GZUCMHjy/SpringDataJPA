package com.example.jpa_demo.RepositoryTest;

import com.example.jpa_demo.Pojo.Entity.Account;
import com.example.jpa_demo.Pojo.Entity.Customer;
import com.example.jpa_demo.Pojo.Entity.QCustomer;
import com.example.jpa_demo.Repository.CustomerRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class OneToOneTest {
    @Autowired
    CustomerRepository customerRepository;
    @Test
    public void test06(){
        Account account = new Account();
        account.setPassword("123456");
        account.setUsername("hjy");
//        account.setId(1);
        Customer customer = new Customer();
//        customer.setId(1);
        customer.setName("hjy");
        customer.setAge(88);
        customer.setAccount(account);
        customerRepository.save(customer);
        QCustomer customer1 = QCustomer.customer;//qdsl是通用的查询框架 拿来添加插入肯定是行不通的！
        BooleanExpression id = customer1.id.eq(1);
        System.out.println(customerRepository.findOne(id));

    }
    @Test
    public void test07(){
        QCustomer customer = QCustomer.customer;
        System.out.println(customerRepository.findOne(customer.id.eq(3)));
    }
}
