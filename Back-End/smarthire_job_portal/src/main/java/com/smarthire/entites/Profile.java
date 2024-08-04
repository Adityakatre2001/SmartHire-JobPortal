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
@Table(name = "profile")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    // Constructors, getters, and setters
	/*
	 * public Profile() { }
	 * 
	 * public Profile(User user, byte[] resume, List<String> skills, String summary,
	 * String experience) { this.user = user; this.resume = resume; this.skills =
	 * skills; this.summary = summary; this.experience = experience; }
	 * 
	 * // Getters and setters
	 * 
	 * public Long getProfileId() { return profileId; }
	 * 
	 * public void setProfileId(Long profileId) { this.profileId = profileId; }
	 * 
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 * 
	 * public byte[] getResume() { return resume; }
	 * 
	 * public void setResume(byte[] resume) { this.resume = resume; }
	 * 
	 * public List<String> getSkills() { return skills; }
	 * 
	 * public void setSkills(List<String> skills) { this.skills = skills; }
	 * 
	 * public String getSummary() { return summary; }
	 * 
	 * public void setSummary(String summary) { this.summary = summary; }
	 * 
	 * public String getExperience() { return experience; }
	 * 
	 * public void setExperience(String experience) { this.experience = experience;
	 * }
	 * 
	 * @Override public String toString() { return "Profile{" + "profileId=" +
	 * profileId + ", user=" + user + ", resume=" + resume + ", skills=" + skills +
	 * ", summary='" + summary + '\'' + ", experience='" + experience + '\'' + '}';
	 * }
	 */
}
