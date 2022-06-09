package ru.kpfu.itis.services;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.*;
import ru.kpfu.itis.models.*;
import ru.kpfu.itis.repositories.*;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumesRepository resumesRepository;
    @Autowired
    private ContactsRepository contactsRepository;
    @Autowired
    private EducationsRepository educationsRepository;
    @Autowired
    private ExperiencesRepository experiencesRepository;
    @Autowired
    private InterestsRepository interestsRepository;
    @Autowired
    private LanguagesRepository languagesRepository;
    @Autowired
    private ProjectsRepository projectsRepository;
    @Autowired
    private SkillsRepository skillsRepository;
    @Autowired
    private RatesRepository ratesRepository;

    @Value("${sender.email}")
    private String senderEmail;

    @Value("${sender.password}")
    private String senderPassword;

    @Override
    public Resume createResume(ResumeForm resumeForm) {
        Resume resume = Resume.builder()
                .title(resumeForm.getTitle())
                .user(resumeForm.getUser())
                .build();
        Resume resume1 = resumesRepository.save(resume);
        sendNotificationEmail(resume1);
        return resume1;
    }

    @Override
    public Resume getById(Long resumeId) {
        Optional<Resume> optional = resumesRepository.findById(resumeId);
        if (optional.isPresent()) {
            Resume resume = optional.get();
            resume.setContacts(findAllContactByResume(resume));
            resume.setEducations(findAllEducationByResume(resume));
            resume.setExperiences(findAllExperienceByResume(resume));
            resume.setInterests(findAllInterestByResume(resume));
            resume.setLanguages(findAllLanguageByResume(resume));
            resume.setProjects(findAllProjectByResume(resume));
            resume.setSkills(findAllSkillsByResume(resume));
            return resume;
        }
        return null;
    }

    @Override
    public List<Resume> findAll() {
        List<Resume> resumes = resumesRepository.findAll();
        for (Resume resume : resumes) {
            resume.setContacts(findAllContactByResume(resume));
            resume.setEducations(findAllEducationByResume(resume));
            resume.setExperiences(findAllExperienceByResume(resume));
            resume.setInterests(findAllInterestByResume(resume));
            resume.setLanguages(findAllLanguageByResume(resume));
            resume.setProjects(findAllProjectByResume(resume));
            resume.setSkills(findAllSkillsByResume(resume));
        }
        return resumes;
    }

    @Override
    public List<Resume> findAllByUser(User user) {
        List<Resume> resumes = resumesRepository.findAllByUser(user);
        for (Resume resume : resumes) {
            resume.setContacts(findAllContactByResume(resume));
            resume.setEducations(findAllEducationByResume(resume));
            resume.setExperiences(findAllExperienceByResume(resume));
            resume.setInterests(findAllInterestByResume(resume));
            resume.setLanguages(findAllLanguageByResume(resume));
            resume.setProjects(findAllProjectByResume(resume));
            resume.setSkills(findAllSkillsByResume(resume));
        }
        return resumes;
    }

    @Override
    public void updateResumeTitle(Long id, String title) {
        resumesRepository.updateResumeTitle(id, title);
    }

    @Override
    public void updateResumeAboutMe(Long id, String aboutMe) {
        resumesRepository.updateResumeAboutMe(id, aboutMe);
    }

    @Override
    public Contact addContact(ContactForm contactForm) {
        Contact contact = Contact.builder()
                .title(contactForm.getTitle())
                .contact(contactForm.getContact())
                .resume(contactForm.getResume())
                .build();
        return contactsRepository.save(contact);
    }

    @Override
    public Language addLanguage(LanguageForm languageForm) {
        Language language = Language.builder()
                .language(languageForm.getLanguage())
                .level(languageForm.getLevel())
                .resume(languageForm.getResume())
                .build();
        return languagesRepository.save(language);
    }

    @Override
    public Education addEducation(EducationForm educationForm) {
        Education education = Education.builder()
                .title(educationForm.getTitle())
                .place(educationForm.getPlace())
                .workTimeInterval(educationForm.getWorkTimeInterval())
                .resume(educationForm.getResume())
                .build();
        return educationsRepository.save(education);
    }

    @Override
    public Experience addExperience(ExperienceForm experienceForm) {
        Experience experience = Experience.builder()
                .title(experienceForm.getTitle())
                .place(experienceForm.getPlace())
                .workTimeInterval(experienceForm.getWorkTimeInterval())
                .description(experienceForm.getDescription())
                .resume(experienceForm.getResume())
                .build();
        return experiencesRepository.save(experience);
    }

    @Override
    public Project addProject(ProjectForm projectForm) {
        Project project = Project.builder()
                .title(projectForm.getTitle())
                .description(projectForm.getDescription())
                .resume(projectForm.getResume())
                .build();
        return projectsRepository.save(project);
    }

    @Override
    public Skill addSkill(SkillForm skillForm) {
        Skill skill = Skill.builder()
                .title(skillForm.getTitle())
                .resume(skillForm.getResume())
                .build();
        return skillsRepository.save(skill);
    }

    @Override
    public Interest addInterest(InterestForm interestForm) {
        Interest interest = Interest.builder()
                .title(interestForm.getTitle())
                .resume(interestForm.getResume())
                .build();
        return interestsRepository.save(interest);
    }

    @Override
    public List<Skill> findAllSkillsByResume(Resume resume) {
        List<Skill> skills = skillsRepository.findAllByResume(resume);
        for (Skill skill : skills) {
            skill.setResume(null);
        }
        return skills;
    }

    @Override
    public List<Contact> findAllContactByResume(Resume resume) {
        List<Contact> contacts = contactsRepository.findAllByResume(resume);
        for (Contact contact : contacts) {
            contact.setResume(null);
        }
        return contacts;
    }

    @Override
    public List<Project> findAllProjectByResume(Resume resume) {
        List<Project> projects = projectsRepository.findAllByResume(resume);
        for (Project project : projects) {
            project.setResume(null);
        }
        return projects;
    }

    @Override
    public List<Experience> findAllExperienceByResume(Resume resume) {
        List<Experience> experiences = experiencesRepository.findAllByResume(resume);
        for (Experience experience : experiences) {
            experience.setResume(null);
        }
        return experiences;
    }

    @Override
    public List<Education> findAllEducationByResume(Resume resume) {
        List<Education> educations = educationsRepository.findAllByResume(resume);
        for (Education education : educations) {
            education.setResume(null);
        }
        return educations;
    }

    @Override
    public List<Language> findAllLanguageByResume(Resume resume) {
        List<Language> languages = languagesRepository.findAllByResume(resume);
        for (Language language : languages) {
            language.setResume(null);
        }
        return languages;
    }

    @Override
    public List<Interest> findAllInterestByResume(Resume resume) {
        List<Interest> interests = interestsRepository.findAllByResume(resume);
        for (Interest interest : interests) {
            interest.setResume(null);
        }
        return interests;
    }

    @Override
    public void sendNotificationEmail(Resume resume) {
        try {
            Email emailMessage = new SimpleEmail();

            emailMessage.setSmtpPort(25);
            emailMessage.setAuthenticator(new DefaultAuthenticator(senderEmail, senderPassword));
            emailMessage.setHostName("smtp.mail.ru");
            emailMessage.setSSLOnConnect(true);

            emailMessage.setFrom(senderEmail);
            emailMessage.setSubject("Created new resume");

            User user = resume.getUser();
            emailMessage.setMsg(user.getFirstName() + " " + user.getLastName() +
                    ",\nYou created a new resume (" + resume.getTitle() + ")\n" +
                    " Now you can edit it from your profile page.");

            emailMessage.addTo(user.getLogin());
            emailMessage.send();
            System.out.println("Successful email send!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error sending email");
        }
    }

    @Override
    public Rate rateResume(RateForm rateForm) {
        Rate rate = Rate.builder()
                .resume(rateForm.getResume())
                .user(rateForm.getUser())
                .rate(rateForm.getRate())
                .build();
        return ratesRepository.save(rate);
    }

    @Override
    public List<Rate> findRatesByResume(Resume resume) {
        return ratesRepository.findAllByResume(resume);
    }

    @Override
    public Float findAverageRateOfResume(Resume resume) {
        List<Rate> rates = findRatesByResume(resume);
        Float average = null;
        if (rates.size() > 0) {
            average = 0f;
            for (Rate rate : rates) {
                average += rate.getRate();
            }
            average /= rates.size();
        }
        return average;
    }

    @Override
    public void updateResumeImage(Long resumeId, String imagePath) {
        resumesRepository.updateUserImage(resumeId, imagePath);
    }

    @Override
    public Rate findRateByUserAndResume(User user, Resume resume) {
        return ratesRepository.findByUserAndResume(user, resume).get();
    }
}
