package com.example.jpa_demo.RepositoryTest;

import com.example.jpa_demo.Pojo.Entity.Customer;
import com.example.jpa_demo.Pojo.Entity.Role;
import com.example.jpa_demo.Repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ManyToManyTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void test13(){
        //在多对多的表关系中 不适合删除(REMOVE)
        Role role = new Role();
        Role role1 = new Role();
        role.setPosition("总监");
        role.setPosition("CEO");
        //当前单个用户
        Customer customer = new Customer();
        //对应多个身份
        customer.getRoleList().add(role);
        customer.getRoleList().add(role1);
        //保存当前用户的多个身份信息(持久化操作)
        customerRepository.save(customer);

    }

}
