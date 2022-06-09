package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Contact;
import ru.kpfu.itis.models.Experience;
import ru.kpfu.itis.models.Resume;

import java.util.List;

@Repository
public interface ExperiencesRepository extends JpaRepository<Experience, Long> {

    List<Experience> findAllByResume(Resume resume);
}
