package com.smarthire.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import lombok.*;

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
