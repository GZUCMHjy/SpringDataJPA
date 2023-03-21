package com.example.jpa_demo.RepositoryTest;

import com.example.jpa_demo.Pojo.Entity.Customer;
import com.example.jpa_demo.Pojo.Entity.Message;
import com.example.jpa_demo.Repository.CustomerRepository;
import com.example.jpa_demo.Repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
public class ManyToOneTest {
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Test
    @Transactional
    public void test09(){
        ArrayList<Message> msgList = new ArrayList<>();
        Customer customer = new Customer();
        //一个用户
        customer.setName("黄景瑜");
        //多条信息
        msgList.add(new Message("加油",customer));
        msgList.add(new Message("你可以的",customer));
        //多个持久化操作saveAll和findAll 需要加 @Transactional!!!
        messageRepository.saveAll(msgList);
        System.out.println(messageRepository.findAll());
    }
    @Test
    @Transactional
    @Commit//(单元测试会认为你的事务方法@Transactional，只是测试而已，它不会为你提交事务，需要单独加上@Commit)
    public  void test10(){
        Optional<Customer> byId = customerRepository.findById(9);
        customerRepository.delete(byId.get());
    }
}
