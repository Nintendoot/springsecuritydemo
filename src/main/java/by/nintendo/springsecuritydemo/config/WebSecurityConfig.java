package by.nintendo.springsecuritydemo.config;

import by.nintendo.springsecuritydemo.servise.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailService userServise;

    public WebSecurityConfig(UserDetailService userServise) {
        this.userServise = userServise;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home", "/reg").permitAll()
                .antMatchers("/logout").hasAnyRole("USER", "ADMIN")
                .antMatchers("/calc").hasRole("USER")
                .antMatchers("/allHistory").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("login")
                .loginPage("/auth").
                defaultSuccessUrl("/home")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/myLogout")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServise).passwordEncoder(bCryptPasswordEncoder());
    }


}
