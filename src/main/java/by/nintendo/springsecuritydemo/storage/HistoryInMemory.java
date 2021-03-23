package by.nintendo.springsecuritydemo.storage;

import by.nintendo.springsecuritydemo.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HistoryInMemory implements HistoryStorage {

    private final List<MyUser> usersHistory = new ArrayList<>();


    @Autowired
    public HistoryInMemory() {
    }

    @Override
    public void addInHistory(MyUser user) {
            usersHistory.add(user);
    }

    @Override
    public List<MyUser> allHistory() {
        return usersHistory;
    }

    public MyUser getUserByLogin(String name) {
        for (MyUser us : usersHistory) {
            if (us.getLogin().equals(name)) {
                return us;
            }
        }
        return null;
    }
}

