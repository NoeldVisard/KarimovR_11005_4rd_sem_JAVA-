package ru.itis.parking.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.itis.parking.security.filtres.JwtTokenAuthenticationFilter;
import ru.itis.parking.security.filtres.JwtTokenAuthorizationFilter;

@EnableWebSecurity
public class JwtSecurityConfiguration  extends WebSecurityConfigurerAdapter {
    public static final String URL = "/drivers";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService driverUserDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("&{jwt.secretKey}")
    private String secretKey;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(driverUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        JwtTokenAuthenticationFilter authenticationFilter =
                new JwtTokenAuthenticationFilter(authenticationManagerBean(), objectMapper, secretKey);
        authenticationFilter.setFilterProcessesUrl(URL);

        JwtTokenAuthorizationFilter authorizationFilter =
                new JwtTokenAuthorizationFilter(objectMapper,secretKey);

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(authenticationFilter);
        http.addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class);

        http.authorizeRequests()
                .antMatchers(URL + "/**").permitAll()
                .antMatchers("/parkingCar/**").hasAuthority("USER")
                .antMatchers("/parking/**").hasAuthority("ADMIN");

    }





}
