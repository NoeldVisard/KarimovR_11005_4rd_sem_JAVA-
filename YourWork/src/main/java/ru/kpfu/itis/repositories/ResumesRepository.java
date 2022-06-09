package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.models.Resume;
import ru.kpfu.itis.models.User;

import java.util.List;
import java.util.Optional;

@Repository("resumesRepository")
@Transactional
public interface ResumesRepository extends JpaRepository<Resume, Long> {

    List<Resume> findAllByUser(User user);

    @Modifying
    @Query("update Resume r set r.title = ?2 where r.id = ?1")
    void updateResumeTitle(Long id, String title);

    @Modifying
    @Query("update Resume r set r.about = ?2 where r.id = ?1")
    void updateResumeAboutMe(Long id, String aboutMe);

    @Modifying
    @Query("update Resume r set r.imagePath = ?2 where r.id = ?1")
    void updateUserImage(Long id, String imagePath);
}
