package ru.kpfu.itis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.models.Resume;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.ResumeService;
import ru.kpfu.itis.services.UsersService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final Logger logger = LoggerFactory.getLogger(ProfileController.class);

    @Value("${custom.absolute.file.storage}")
    private String absoluteFilePath;

    @Value("${custom.file.storage}")
    private String filePath;

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ModelAndView getProfilePage(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView("profile");
        User user = (User) authentication.getPrincipal();
        modelAndView.addObject("user", user);
        List<Resume> resumes = resumeService.findAllByUser(user);
        modelAndView.addObject("resumes", resumes);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView changeImage(MultipartFile userImage, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        if (userImage != null) {
            logger.info("Загружаем файл");
            String fileName = userImage.getOriginalFilename();
            try {
                userImage.transferTo(new File(absoluteFilePath + fileName));
                usersService.updateUserImage(user.getId(), filePath + fileName);
            } catch (IOException e) {
                logger.error("Произошла ошибка во время загрузки файла");
            }
            logger.info("Файл успешно загружен");
        }
        return new ModelAndView("redirect:/profile");
    }
}
