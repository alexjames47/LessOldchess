package dataaccess;

import model.UserData;
import org.eclipse.jetty.server.Authentication;

public interface UserDAO {
    void clear();
    void addUser(UserData user);
}
