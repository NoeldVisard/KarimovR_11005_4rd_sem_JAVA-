package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.models.Resume;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.AuthRepository;
import ru.kpfu.itis.repositories.UsersRepository;

import javax.servlet.http.Cookie;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsersServicesImpl implements UsersService {

    @Autowired
    @Qualifier("usersRepository")
    private UsersRepository usersRepository;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(UserForm userForm) {

        User user = new User();
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setLogin(userForm.getLogin());

        String passwordHash = new BCryptPasswordEncoder().encode(userForm.getPassword());

        user.setPasswordHash(passwordHash);

        return usersRepository.save(user);
    }

    @Override
    public Cookie signIn(LoginForm loginForm) {

        Optional<User> optionalUser = usersRepository.findByLogin(loginForm.getLogin());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginForm.getPassword(), user.getPasswordHash())) {
                System.out.println("Вход выполнен!");
                String cookieValue = UUID.randomUUID().toString();
                System.out.println(cookieValue);
                Cookie cookie = new Cookie("auth", cookieValue);
                cookie.setMaxAge(10 * 60 * 60);
                return cookie;
            } else {
                System.out.println("Вход не выполнен!");
            }
        }
        return null;
    }

    @Override
    public void updateUserImage(Long userId, String imageSrc) {
        usersRepository.updateUserImage(userId, imageSrc);
    }
}
