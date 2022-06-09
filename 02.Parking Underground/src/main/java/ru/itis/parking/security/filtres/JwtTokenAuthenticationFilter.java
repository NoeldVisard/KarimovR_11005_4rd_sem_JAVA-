package ru.itis.parking.security.filtres;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.itis.parking.dto.LoginPasswordDto;
import ru.itis.parking.models.Driver;
import ru.itis.parking.security.details.DriverUserDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Slf4j
public class JwtTokenAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper;
    private final String secretKey;


    public JwtTokenAuthenticationFilter(AuthenticationManager auth, ObjectMapper objectMapper, String secretKey) {
        super(auth);
        this.objectMapper = objectMapper;
        this.secretKey = secretKey;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginPasswordDto loginPassword = objectMapper.readValue(request.getReader(), LoginPasswordDto.class);
            log.info("Attempt authentication - login {}", loginPassword.getLogin());
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(loginPassword.getLogin(), loginPassword.getPassword());
            return super.getAuthenticationManager().authenticate(token);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        DriverUserDetails userDetails = (DriverUserDetails) authResult.getPrincipal();
        Driver driver = userDetails.getDriver();

        String token = JWT.create()
                .withSubject(driver.getId().toString())
                .withClaim("login", driver.getLogin())
                .withClaim("role", driver.getRole().toString())
                .withClaim("state", driver.getState().toString())
                .sign(Algorithm.HMAC256(secretKey));

        objectMapper.writeValue(response.getWriter(), Collections.singletonMap("token", token));
    }
}

