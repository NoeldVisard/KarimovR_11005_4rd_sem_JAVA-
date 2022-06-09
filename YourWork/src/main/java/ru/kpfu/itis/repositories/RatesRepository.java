package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.models.Rate;
import ru.kpfu.itis.models.Resume;
import ru.kpfu.itis.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatesRepository extends JpaRepository<Rate, Long> {

    List<Rate> findAllByResume(Resume resume);

    Optional<Rate> findByUserAndResume(User user, Resume resume);
}
