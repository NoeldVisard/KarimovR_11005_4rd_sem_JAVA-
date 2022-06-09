package ru.kpfu.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.itis.dto.SignInDto;
import ru.kpfu.itis.dto.SignUpDto;
import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    @GetMapping
    public ModelAndView getSignInPage() {
        return new ModelAndView("signIn");
    }
}
