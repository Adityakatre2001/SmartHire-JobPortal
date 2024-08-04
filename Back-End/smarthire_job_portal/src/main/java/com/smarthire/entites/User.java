package com.smarthire.entites;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull
    @Size(max = 15)
    @Column(nullable = false, length = 15)
    private String contact;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String username;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String password;

    @NotNull
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String email;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String fname;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String lname;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Profile> profiles;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> receivedMessages;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications;

    // Constructors, getters, and setters

	/*
	 * public User() { }
	 * 
	 * public User(String role, String contact, String username, String password,
	 * String email, String fname, String lname) { this.role = role; this.contact =
	 * contact; this.username = username; this.password = password; this.email =
	 * email; this.fname = fname; this.lname = lname; }
	 * 
	 * // Getters and setters
	 * 
	 * public Long getUserId() { return userId; }
	 * 
	 * public void setUserId(Long userId) { this.userId = userId; }
	 * 
	 * public String getRole() { return role; }
	 * 
	 * public void setRole(String role) { this.role = role; }
	 * 
	 * public String getContact() { return contact; }
	 * 
	 * public void setContact(String contact) { this.contact = contact; }
	 * 
	 * public String getUsername() { return username; }
	 * 
	 * public void setUsername(String username) { this.username = username; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 * 
	 * public String getFname() { return fname; }
	 * 
	 * public void setFname(String fname) { this.fname = fname; }
	 * 
	 * public String getLname() { return lname; }
	 * 
	 * public void setLname(String lname) { this.lname = lname; }
	 * 
	 * public List<Profile> getProfiles() { return profiles; }
	 * 
	 * public void setProfiles(List<Profile> profiles) { this.profiles = profiles; }
	 * 
	 * public List<Message> getSentMessages() { return sentMessages; }
	 * 
	 * public void setSentMessages(List<Message> sentMessages) { this.sentMessages =
	 * sentMessages; }
	 * 
	 * public List<Message> getReceivedMessages() { return receivedMessages; }
	 * 
	 * public void setReceivedMessages(List<Message> receivedMessages) {
	 * this.receivedMessages = receivedMessages; }
	 * 
	 * public Company getCompany() { return company; }
	 * 
	 * public void setCompany(Company company) { this.company = company; }
	 * 
	 * public List<Application> getApplications() { return applications; }
	 * 
	 * public void setApplications(List<Application> applications) {
	 * this.applications = applications; }
	 * 
	 * @Override public String toString() { return "User{" + "userId=" + userId +
	 * ", role='" + role + '\'' + ", contact='" + contact + '\'' + ", username='" +
	 * username + '\'' + ", password='" + password + '\'' + ", email='" + email +
	 * '\'' + ", fname='" + fname + '\'' + ", lname='" + lname + '\'' + ", company="
	 * + company + '}'; }
	 */
}
