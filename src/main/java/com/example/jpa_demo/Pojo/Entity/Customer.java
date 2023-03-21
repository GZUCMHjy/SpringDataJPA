package com.example.jpa_demo.Pojo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_customer")//对象映射表名
//@RequiredArgsConstructor//有final的属性有加上构造器 没有则加上无参构造器 @Data含有这个注解
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//相当于mysql中id自增(auto increment)
    private Integer id;
    private String name;
    private Integer age;

    //单向关联一对一
    //配置关联操作
    // 1. cascade
    //  ALL 所有关联操作(入门无脑选这个)
    //  PERSIST 插入
    //  MERGE 修改
    //  REMOVE 删除
    // 2. fetch 设置是否懒加载
    //  EAGER 默认立即加载
    //  LAZY  只有用到对象才开始加载(挺好的这个 提高多表查询的效率)
    // 3. mappedBy 当一对一双向关联时间,需要有一方放弃关联 要不然会造成闭环 使得出现一些多余的多表关联操作(update更新) 从而影响效率
    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)//需要在在配置文件设置开启懒加载
    //设置外键id字段名
    @JoinColumn(name = "account_id")
    private  Account account;

    //用户可以有多条信息List集合 需要容器！
    //一对多默认懒加载 且customer表是被维护端
    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY/*,mappedBy = "customer"*/)
    //添加外键字段名 因为一个用户就有n条信息 如果外键字段名是message_id 那每找一条信息就要查询一次customer就很没有必要啊
    //如果外键字段名是customer_id，则查一次customer_id就可以找到多条信息 这不很好？
    //此外建是建立在tb_message表中的
    //一对多，两张表，多的表加主表外键
    @JoinColumn(name = "customer_id")
    private List<Message> message;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //需要容器 可以List或者是Set集合
    //下面代码可写可不写(要想自定义那就没关系 可以写) 因为JPA会自动生成一张中间表
    /*@JoinTable(
            name = "tb_customer_role",//设置中间表名
            joinColumns = {@JoinColumn(name = "c_id")},//设置本表的外键名称
            inverseJoinColumns = {@JoinColumn(name = "r_id")}//设置关联表的名称
    )*///多行注释 Ctrl+shift+/
    private List<Role> roleList=new ArrayList<>();

    private @Version Long version;//原理乐观锁 防止对数据库进行并发操作 通过改变版本号 使得紧接着的修改无法进行对数据进行修改


}
