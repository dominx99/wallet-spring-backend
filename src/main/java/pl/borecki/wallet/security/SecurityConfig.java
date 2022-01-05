package pl.borecki.wallet.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.borecki.wallet.filter.CustomAuthenticationFilter;

import javax.persistence.GeneratedValue;

import static org.springframework.security.config.http.SessionCreationPolicy.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService; // reszta w UserServicImplementation
    private final BCryptPasswordEncoder bCryptPasswordEncoder; //reszta w WalletApplication

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeHttpRequests().anyRequest().permitAll();
        http.addFilter(new CustomAuthenticationFilter(authenticationManagerBean()));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean () throws Exception{
        return super.authenticationManagerBean();
    }
}
