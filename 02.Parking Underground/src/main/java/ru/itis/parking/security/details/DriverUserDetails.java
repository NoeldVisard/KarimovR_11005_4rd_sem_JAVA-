package ru.itis.parking.security.details;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itis.parking.models.Driver;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
@Data
public class DriverUserDetails implements UserDetails {

    private final Driver driver;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(driver.getRole().name()));
    }


    @Override
    public String getPassword() {
        return driver.getPassword() ;
    }

    @Override
    public String getUsername() {
        return driver.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return  !driver.getState().equals(Driver.State.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return driver.getState().equals(Driver.State.CONFIRMED);
    }

}
