package ru.itis.parking.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.parking.models.Driver;
import ru.itis.parking.validation.annotations.NotSameNames;
import ru.itis.parking.validation.annotations.PasswordEqual;

import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NotSameNames( names = {"firstName", "lastName"}, message = "{names} are same")
@PasswordEqual(names = {"password", "samePassword"}, message = "{names} don't match")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DriverDto {
    private String firstName;

    private String lastName;

    @NotBlank(message = "Enter login")
    private String login;

    @NotBlank(message = "Enter password")
    @Size(min = 2, max = 10, message = "Min size - {min}, Max size - {max}")
    private String password;

    private String samePassword;

    private Driver.Role role;

    private Driver.State state;

}
