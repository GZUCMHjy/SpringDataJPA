package com.example.jpa_demo.RepositoryTest;

import com.example.jpa_demo.Pojo.Entity.Customer;
import com.example.jpa_demo.Pojo.Entity.Message;
import com.example.jpa_demo.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.rmi.MarshalException;
import java.util.ArrayList;

@SpringBootTest

public class OneToManyTest {
    @Autowired
    CustomerRepository customerRepository;
    @Test
    public void test08(){
        //插入
        Customer customer = new Customer();
        customer.setAge(18);
        ArrayList<Message> msgList = new ArrayList<>();
        msgList.add(new Message("八嘎呀路"));
        customer.setMessage(msgList);
        customerRepository.save(customer);
        System.out.println(customer);
    }
}
