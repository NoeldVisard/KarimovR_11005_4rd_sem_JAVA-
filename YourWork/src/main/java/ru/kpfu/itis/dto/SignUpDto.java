package ru.kpfu.itis.dto;

import lombok.Data;

@Data
public class SignUpDto {

    private String login;
    private String firstName;
    private String lastName;
    private String password;
    private String retype_password;
}
