package ru.itis.parking.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.parking.repositories.DriverRepository;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class DriverUserDetailsService implements UserDetailsService {

    private final DriverRepository driverRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException  {
        return new DriverUserDetails(
            driverRepository.findByLogin(login)
                    .orElseThrow( () -> new UsernameNotFoundException("User not found")));

    }
}
