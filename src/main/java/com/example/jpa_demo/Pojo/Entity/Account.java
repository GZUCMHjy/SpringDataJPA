package com.example.jpa_demo.Pojo.Entity;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.Data;
import lombok.Value;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_account")//对象映射表名
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    @OneToOne
    //双向关联 设置外键
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
