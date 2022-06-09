package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Contact;
import ru.kpfu.itis.models.Education;
import ru.kpfu.itis.models.Language;
import ru.kpfu.itis.models.Resume;

import java.util.List;

@Repository
public interface LanguagesRepository extends JpaRepository<Language, Long> {

    List<Language> findAllByResume(Resume resume);
}
