package ru.kpfu.itis.services;

import ru.kpfu.itis.form.*;
import ru.kpfu.itis.models.*;

import java.util.List;

public interface ResumeService {

    Resume createResume(ResumeForm resumeForm);

    Resume getById(Long resumeId);

    List<Resume> findAll();

    List<Resume> findAllByUser(User user);

    void updateResumeTitle(Long id, String title);

    void updateResumeAboutMe(Long id, String aboutMe);

    Contact addContact(ContactForm contactForm);

    Language addLanguage(LanguageForm languageForm);

    Education addEducation(EducationForm educationForm);

    Experience addExperience(ExperienceForm experienceForm);

    Project addProject(ProjectForm projectForm);

    Skill addSkill(SkillForm skillForm);

    Interest addInterest(InterestForm interestForm);

    List<Skill> findAllSkillsByResume(Resume resume);

    List<Contact> findAllContactByResume(Resume resume);

    List<Project> findAllProjectByResume(Resume resume);

    List<Experience> findAllExperienceByResume(Resume resume);

    List<Education> findAllEducationByResume(Resume resume);

    List<Language> findAllLanguageByResume(Resume resume);

    List<Interest> findAllInterestByResume(Resume resume);

    void sendNotificationEmail(Resume resume);

    Rate rateResume(RateForm rateForm);

    List<Rate> findRatesByResume(Resume resume);

    Float findAverageRateOfResume(Resume resume);

    void updateResumeImage(Long resumeId, String imagePath);

    Rate findRateByUserAndResume(User user, Resume resume);
}

