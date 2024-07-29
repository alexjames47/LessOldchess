package dataAccess.memoryDOAs;

import dataAccess.UserDAO;
import model.UserData;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserDAO implements UserDAO {

    private final Map<String, UserData> userList = new HashMap<>();

    @Override
    public void clear() {
        userList.clear();
    }

    @Override
    public void addUser(UserData user) {
        userList.put(user.username(), user);
    }
}
