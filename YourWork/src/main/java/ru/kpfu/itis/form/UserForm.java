package ru.kpfu.itis.form;

import lombok.Data;

@Data
public class UserForm {
    private String login;
    private String password;
    private String lastName;
    private String firstName;
}
