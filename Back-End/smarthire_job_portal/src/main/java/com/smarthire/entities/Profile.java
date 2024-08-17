package com.smarthire.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Profile {

  
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long profileId;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    private User user;
    
    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 15)
    private String contact;

    @Lob
    @Column
    private byte[] resume;

    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(name = "profile_id"))
    @Column(name = "skill")
    private List<String> skills;

    @Size(max = 5000)
    @Column(length = 5000)
    private String summary;

    @Size(max = 5000)
    @Column(length = 5000)
    private String experience;

    // Optional: You can add constructors, getters, and setters if not using Lombok
}
