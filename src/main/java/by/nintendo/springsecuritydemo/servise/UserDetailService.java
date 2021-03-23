package by.nintendo.springsecuritydemo.servise;

import by.nintendo.springsecuritydemo.entity.MyUser;
import by.nintendo.springsecuritydemo.storage.UserStorage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserStorage userStorage;

    public UserDetailService(@Qualifier("userInMemory") UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        MyUser us = userStorage.getByLogin(login);

        if (us == null) {
            throw new UsernameNotFoundException("User not found");
        } else {
            UserDetails uss= User.builder()
                    .username(us.getLogin())
                    .password(us.getPassword())
                    .roles(us.getRole().getIteam())
                    .build();
            return uss;
            }

        }
    }
