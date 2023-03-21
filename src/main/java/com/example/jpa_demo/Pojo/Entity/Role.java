package com.example.jpa_demo.Pojo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="tb_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //具体岗位
    private String position;
    //可双向可单向连接 这里我就单向了 不想多一张表出来
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "customer_id")
//    private List<Customer> customerList;


}
