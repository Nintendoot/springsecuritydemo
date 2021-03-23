package by.nintendo.springsecuritydemo.storage;

import by.nintendo.springsecuritydemo.entity.MyUser;

import java.util.List;

public interface HistoryStorage {

    void addInHistory(MyUser user);

    List<MyUser> allHistory();

}
