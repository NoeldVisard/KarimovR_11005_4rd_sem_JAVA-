package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Contact;
import ru.kpfu.itis.models.Education;
import ru.kpfu.itis.models.Resume;
import ru.kpfu.itis.models.Skill;

import java.util.List;

@Repository
public interface SkillsRepository extends JpaRepository<Skill, Long> {

    List<Skill> findAllByResume(Resume resume);
}
