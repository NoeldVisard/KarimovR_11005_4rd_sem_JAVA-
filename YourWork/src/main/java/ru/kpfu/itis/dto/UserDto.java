package ru.kpfu.itis.dto;

import lombok.Data;

@Data
public class UserDto {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String retype_password;
}
