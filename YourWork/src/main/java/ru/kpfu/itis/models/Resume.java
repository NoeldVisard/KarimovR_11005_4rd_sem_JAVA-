package ru.kpfu.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "about")
    private String about;

    @Column(name = "image_path")
    private String imagePath;

    @OneToMany
    private List<Contact> contacts;

    @OneToMany
    private List<Education> educations;

    @OneToMany
    private List<Language> languages;

    @OneToMany
    private List<Interest> interests;

    @OneToMany
    private List<Experience> experiences;

    @OneToMany
    private List<Project> projects;

    @OneToMany
    private List<Skill> skills;
}
