package com.smarthire.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @NotNull
    @Size(max = 100)
    @Column(name = "company_name", nullable = false, length = 100)
    private String companyName;

    @NotNull
    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String industry;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String location;

    @Size(max = 5000)
    @Column(length = 5000)
    private String description;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JobPosting> jobPostings = new ArrayList<>();

}
