package ru.itis.parking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Driver {

    public enum Role{
        USER, ADMIN
    };

    public enum State {
        NOT_CONFIRMED, CONFIRMED, DELETED, BANNED
    };

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String login;

    private String password;

    private Long money;

    @OneToMany(mappedBy = "driver")
    private List<Car> cars;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    private String token;

}