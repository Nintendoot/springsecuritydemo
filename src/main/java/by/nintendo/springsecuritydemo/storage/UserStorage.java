package by.nintendo.springsecuritydemo.storage;

import by.nintendo.springsecuritydemo.entity.MyUser;

import java.util.List;

public interface UserStorage {
    List<MyUser> allList();

    boolean userInMemori(MyUser user);

    void addInMemory(MyUser user);

    boolean checkLoginAndPassword(MyUser user);

    public MyUser getByLogin(String name);
}
