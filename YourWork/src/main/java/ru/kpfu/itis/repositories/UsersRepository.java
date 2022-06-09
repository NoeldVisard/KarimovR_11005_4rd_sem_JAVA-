package ru.kpfu.itis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.models.User;

import java.util.Optional;

@Repository("usersRepository")
@Transactional
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    @Modifying
    @Query("update User r set r.imageSrc = ?2 where r.id = ?1")
    void updateUserImage(Long id, String imageSrc);
}
