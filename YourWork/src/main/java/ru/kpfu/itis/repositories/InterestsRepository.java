package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Contact;
import ru.kpfu.itis.models.Interest;
import ru.kpfu.itis.models.Project;
import ru.kpfu.itis.models.Resume;

import java.util.List;

@Repository
public interface InterestsRepository extends JpaRepository<Interest, Long> {

    List<Interest> findAllByResume(Resume resume);
}
