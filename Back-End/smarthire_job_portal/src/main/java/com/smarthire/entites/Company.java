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
@Table(name = "company")
@Getter
@Setter
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

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    // Constructors, getters, and setters

	/*
	 * public Company() { }
	 * 
	 * public Company(String companyName, String industry, String location, String
	 * description) { this.companyName = companyName; this.industry = industry;
	 * this.location = location; this.description = description; }
	 * 
	 * // Getters and setters
	 * 
	 * public Long getCompanyId() { return companyId; }
	 * 
	 * public void setCompanyId(Long companyId) { this.companyId = companyId; }
	 * 
	 * public String getCompanyName() { return companyName; }
	 * 
	 * public void setCompanyName(String companyName) { this.companyName =
	 * companyName; }
	 * 
	 * public String getIndustry() { return industry; }
	 * 
	 * public void setIndustry(String industry) { this.industry = industry; }
	 * 
	 * public String getLocation() { return location; }
	 * 
	 * public void setLocation(String location) { this.location = location; }
	 * 
	 * public String getDescription() { return description; }
	 * 
	 * public void setDescription(String description) { this.description =
	 * description; }
	 * 
	 * public List<User> getUsers() { return users; }
	 * 
	 * public void setUsers(List<User> users) { this.users = users; }
	 * 
	 * @Override public String toString() { return "Company{" + "companyId=" +
	 * companyId + ", companyName='" + companyName + '\'' + ", industry='" +
	 * industry + '\'' + ", location='" + location + '\'' + ", description='" +
	 * description + '\'' + ", users=" + users + '}'; }
	 */
}
