package com.smarthire.entites;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
//import java.util.Date;

@Entity
@Table(name = "message")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    @NotNull
    @Size(max = 5000)
    @Column(name = "message_content", nullable = false, length = 5000)
    private String messageContent;

    @NotNull
    //@Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "message_time", nullable = false)
    private LocalDate messageTime;

    // Constructors, getters, and setters
	/*
	 * public Message() { }
	 * 
	 * public Message(User sender, User receiver, String messageContent, Local Date
	 * messageTime) { this.sender = sender; this.receiver = receiver;
	 * this.messageContent = messageContent; this.messageTime = messageTime; }
	 * 
	 * // Getters and setters
	 * 
	 * public Long getMessageId() { return messageId; }
	 * 
	 * public void setMessageId(Long messageId) { this.messageId = messageId; }
	 * 
	 * public User getSender() { return sender; }
	 * 
	 * public void setSender(User sender) { this.sender = sender; }
	 * 
	 * public User getReceiver() { return receiver; }
	 * 
	 * public void setReceiver(User receiver) { this.receiver = receiver; }
	 * 
	 * public String getMessageContent() { return messageContent; }
	 * 
	 * public void setMessageContent(String messageContent) { this.messageContent =
	 * messageContent; }
	 * 
	 * public LocalDate getMessageTime() { return messageTime; }
	 * 
	 * public void setMessageTime(LocalDate messageTime) { this.messageTime =
	 * messageTime; }
	 * 
	 * @Override public String toString() { return "Message{" + "messageId=" +
	 * messageId + ", sender=" + sender + ", receiver=" + receiver +
	 * ", messageContent='" + messageContent + '\'' + ", messageTime=" + messageTime
	 * + '}'; }
	 */
}
