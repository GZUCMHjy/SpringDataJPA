package com.example.jpa_demo.Pojo.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    private String content;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)//REMOVE删除子表信息同时也会将关联的父表的数据删除
    //外键为主表(customer)的id
    @JoinColumn(name = "customer_id")
    private Customer customer;
    //要添加无参构造器！
    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public Message(String content, Customer customer) {
        this.content = content;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", content='" + content + '\'' +
                ", customerId=" + customer.getId() +
                ", customerName=" + customer.getName() +
                '}';
    }
}
