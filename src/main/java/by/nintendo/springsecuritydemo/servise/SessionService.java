package by.nintendo.springsecuritydemo.servise;

import by.nintendo.springsecuritydemo.entity.MyUser;
import by.nintendo.springsecuritydemo.storage.UserStorage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    private final UserStorage userStorage;

    public SessionService(@Qualifier("userInMemory") UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public MyUser getSession(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails)principal).getUsername();
        return userStorage.getByLogin(username);
    }

}
