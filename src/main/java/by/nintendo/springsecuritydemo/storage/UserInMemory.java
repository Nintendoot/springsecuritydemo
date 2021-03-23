package by.nintendo.springsecuritydemo.storage;

import by.nintendo.springsecuritydemo.entity.MyUser;
import by.nintendo.springsecuritydemo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserInMemory implements UserStorage {
    private final List<MyUser> userList = new ArrayList<>();

    {
        MyUser user = new MyUser();
        user.setLogin("admin");
        user.setPassword("$2a$10$3yj.n/J4XAKJizvU8hAFKuYh5991ZEgQaWk.b9yOrmpFTVgSol2AC");
        user.setRole(Role.ADMIN);
        userList.add(user);
    }

    @Autowired
    public UserInMemory() {
    }

    @Override
    public List<MyUser> allList() {
        return userList;
    }

    @Override
    public boolean userInMemori(MyUser user) {
        boolean result = false;
        for (MyUser us : userList) {
            if (us.getLogin().equals(user.getLogin())) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean checkLoginAndPassword(MyUser user) {
        boolean result = false;
        for (MyUser us : userList) {
            if (us.getLogin().equals(user.getLogin()) && us.getPassword().equals(user.getPassword())) {
                result = true;
            }
        }
        return result;
    }


    @Override
    public MyUser getByLogin(String name) {
        for (MyUser u : userList) {
            if (name.equals(u.getLogin())) {
                return u;
            }
        }
        return null;
    }

    @Override
    public void addInMemory(MyUser user) {
        userList.add(user);
    }
}
