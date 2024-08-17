package com.smarthire.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
   

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

 

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
    
    
    

   
}
