package com.smarthire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarthire.entities.Message;
import com.smarthire.entities.User;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    
    List<Message> findBySender(User senderId);

    
    List<Message> findByReceiver(User receiverId);
}

