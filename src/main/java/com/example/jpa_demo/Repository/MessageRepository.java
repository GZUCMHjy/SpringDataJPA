package com.example.jpa_demo.Repository;

import com.example.jpa_demo.Pojo.Entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Integer> {
}
