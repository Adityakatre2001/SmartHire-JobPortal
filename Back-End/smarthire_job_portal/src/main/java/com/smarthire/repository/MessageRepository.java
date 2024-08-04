package com.smarthire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smarthire.entites.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    // Find messages sent by a specific user
    List<Message> findBySender_UserId(Long senderId);

    // Find messages received by a specific user
    List<Message> findByReceiver_UserId(Long receiverId);
}

